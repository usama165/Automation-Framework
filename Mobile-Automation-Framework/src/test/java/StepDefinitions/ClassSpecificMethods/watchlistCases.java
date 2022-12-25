package StepDefinitions.ClassSpecificMethods;
import StepDefinitions.Controls.Button;
import StepDefinitions.Controls.General;
import StepDefinitions.Controls.Labels;
import com.appium.Main.Factory.factory;
import StepDefinitions.Controls.Textbox;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.JsonClasses.ParseLocators;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
/*import org.aspectj.bridge.Message;*/
//import jdk.jfr.internal.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;


public class watchlistCases {
    public static watchlistCases Instance = null;

    public static watchlistCases Instance() {
        {
            if (Instance == null) {
                Instance = new watchlistCases();

            }
            return Instance;
        }
    }


    @Given("Fill Multiple Values {string} button {string}")
    public void FillMultipleSymbols(String value, String buttonvalue, DataTable table) {
        General.Instance().Wait(3000);
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        if (data.isEmpty()) {
            MyLogger.log.info("symbols list not found");
        } else {
            for (int i = 0; i < data.size(); i++) {


                General.Instance().Wait(1000);
                Textbox.Instance().FillTextBox(value, data.get(i).get("key"));
                Button.Instance().ClickButton(buttonvalue);
                MyLogger.log.info("Symbol Added");
            }
        }


    }


    @And("WatchList Existance Or Not {string}")
    public void checkWatchlistExistance(String validateFromText) {

        String watchlistNotEx = Labels.Instance().GetText(validateFromText);
        if (watchlistNotEx.isEmpty() || watchlistNotEx == null) {
            MyLogger.log.info("Value is not found " + watchlistNotEx);
        } else {
            Assert.assertEquals(watchlistNotEx, "You have no watchlist added.");
        }

    }

    @And("WatchList is created {string}")
    public void watchListExistance(String WatchListName) {
        String watchlistName = Labels.Instance().GetText(WatchListName);
        if (watchlistName == null || watchlistName.isEmpty()) {
            MyLogger.log.info("Watchlist is not created");
        } else {
            MyLogger.log.info("Watchlist is created");
        }

    }

    @And("Is Watchlist Popup Exist {string}")
    public void isWatchlistPopupExist(String addWatchlistText) {


        String WatchlistPopup = Labels.Instance().GetText(addWatchlistText);
        if (WatchlistPopup.isEmpty() || WatchlistPopup == null) {

            MyLogger.log.info("Watchlist Popup has not opened");
        } else {
            MyLogger.log.info("Watchlist Popup has opened Sucessfully");
        }
    }

    @And("Validate symbolORWatchlist Existance {string}")
    public void validateSymbolOrwatchlistExistance(String Value, DataTable table) {
        int fail = 0;
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        List<MobileElement> list1 = ElementFinder.Instance.GetElementList(Value, factory.driver); // size = 3
        for (int d = 0; d < data.size(); d++) // [ QQQ, MSFT , IBM , SNAP ] size 4
        {
            String DataTableValue = data.get(d).get("key");
            for (int i = 0; i < list1.size(); i++) {
                String listValue = list1.get(i).getText();
                if (DataTableValue.equals(listValue)) {
                    MyLogger.log.info(DataTableValue + " is exist  ");
                    break;
                } else if (i == list1.size() - 1) {
                    MyLogger.log.info(DataTableValue + "Symbol doesn't exist");
                    fail++;
                }
            }
        }

    }

    @Given("Addmultiplewatchlists")
    public void addmultiplewatchlists(DataTable table) {
        General.Instance().Wait(2000);
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        if (data.isEmpty()) {
            MyLogger.log.info("symbols list not found");
        } else {
            for (int i = 0; i < data.size(); i++) {


                Textbox.Instance().FillTextBox("ManageWatchlistTextBox", data.get(i).get("Symbol"));
                General.Instance.Wait(2000);
                Button.Instance().ClickButton("ManageWatchListAddButton");
                MyLogger.log.info("Symbol Added");
            }
        }

    }

    @And("checkWatchlistsExistOrNotInManageWatchlist {string}")
    public void checkwWtchlistsExistOrNotInManageWatchlist(String listOFWatchlists, DataTable table) {
        int fail = 0;
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        List<MobileElement> watchlistList = ElementFinder.Instance.GetElementList(listOFWatchlists, factory.driver);
        for (int d = 0; d < data.size(); d++) {
            String DataTableValue = data.get(d).get("Symbol");
            for (int i = 0; i < watchlistList.size(); i++) {
                String WatchlistlistValue = watchlistList.get(i).getText();
                if (DataTableValue.equals(WatchlistlistValue)) {
                    MyLogger.log.info(DataTableValue + " is exist  ");
                    break;
                } else if (i == watchlistList.size() - 1) {
                    MyLogger.log.info(DataTableValue + "Watchlist doesn't exist");
                    fail++;
                }
            }
        }

    }

// we must set these values as a integer because if we set on double so if the value will show the dash (-) then it will throw the exception for syntax
    //   second thing is that if you will login without data agreemnet is shows you the retry string so thats why the double is failed here.



}






