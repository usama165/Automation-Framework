package StepDefinitions.ClassSpecificMethods;

import StepDefinitions.Controls.Button;
import StepDefinitions.Controls.General;
import StepDefinitions.Controls.MobileAlerts;
import StepDefinitions.Controls.Textbox;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.DriverClasses.iOS;
import com.appium.Main.Factory.factory;
import com.appium.Main.File.TextFileHelper;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


public class Order
{
    public static Order Instance=null;
    public static Order Instance() {
        {
            if (Instance == null)
            {
                Instance = new Order();

            }
            return Instance;
        }
    }

    @When("Action on Order Successfully Created pop up {string}")
    public void orderCreatedPopUp(String Action)
    {
      if(App.key.equals("iOS"))
        {
            if(Action.equals("Ok"))
            {
                MobileAlerts.Instance().AcceptAlert();
            }

            else
            {
                MyLogger.log.error("Invalid Action input "+Action+ " Use \"OK\" to Close the order Pop- Up");
                Assert.fail();
            }
        }
    }

    @Given("Add Multiple Symbols of this file {string} and verify Company Info")
    public void AddMultipleSymbols(String Filename)
    {
        ArrayList<String> list=null;
        list= TextFileHelper.Instance().GetArrayListFromFile(Filename);
        for(String s: list){
            try
            {
                General.Instance().Wait(5000);
                Textbox.Instance().FillTextBox("SymbolField", s);
                Button.Instance().ClickButton("AddSymbolIcon");
                General.Instance().Wait(3000);
                String text = Textbox.Instance().GetTextOfTextbox("CompanyInfoLabel");

                if (text.equals("N/A")) {
                    MyLogger.log.error("Company name is not present for " + s);
                    TextFileHelper.Instance().WriteEachLineInFile(s);
                }
            }
            catch(Exception ex)
            {
                MyLogger.log.error(s+ "issue while testing this symbol retest them");
            }
        }
    }

    @And("Get Values {string}")
    public void get_values(String dropdownList) {
        List<MobileElement> dropDownValues= ElementFinder.Instance.GetElementList(dropdownList, factory.driver);
        for(int i=0 ; i<dropDownValues.size(); i++){
            String Values=dropDownValues.get(i).getText();
            MyLogger.log.info(Values);
        }
    }
}
