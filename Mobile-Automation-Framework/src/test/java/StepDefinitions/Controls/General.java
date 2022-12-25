package StepDefinitions.Controls;

import StepDefinitions.ClassSpecificMethods.Login;
import com.appium.Main.DriverClasses.Android;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.DriverClasses.GeneralHelper;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.GlobalVariables;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import io.appium.java_client.MobileElement;

import java.time.Duration;
import java.util.*;


public class General {
    public static General Instance = null;

    public static General Instance() {
        {
            if (Instance == null) {
                Instance = new General();

            }
            return Instance;
        }
    }

    @And("Wait for {int}")
    public void Wait(int TimeInMilliseconds) {
        GeneralHelper.Instance().Wait(TimeInMilliseconds);
    }

    @And("Wait for Visibilty till {int}")
    public void WaitForVisibility(int TimeInSeconds, MobileElement element) {
        GeneralHelper.Instance().WaitForVisibility(TimeInSeconds, element);
    }

    @And("Wait Until Alert is present")
    public void WaitUntilAlertIsPresent() {
        GeneralHelper.Instance().WaitUntilAlertIsPresent();
    }

    @And("Log Message {string} {string}")
    public void LogMessage(String LoggingType, String Message) {
        GeneralHelper.Instance().LogMessage(LoggingType, Message);
    }

    @Then("Check the Presence of {string}")
    public void CheckPresenceOfElement(String Key) {
        GeneralHelper.Instance().CheckPresenceOfElement(Key);
    }

    @And("Close App")
    public void closeApp() {
        GeneralHelper.Instance().closeApp();
    }

    @And("Launch App")
    public void launchApp() {
        GeneralHelper.Instance().launchApp();
    }

    @Given("Check if the user is login")
    public void CheckIfTheUserIsLogin() {

        if (factory.driver != null) {
            try {

                MobileElement element = ElementFinder.Instance().FindElement("NavBar", factory.driver);
                WaitForVisibility(5, element);

                if (element.isDisplayed()) {
                    MyLogger.log.info("User is logged in");

                }
            } catch (Exception ex) {
                try {

                    MobileElement element = ElementFinder.Instance().FindElement("SessionTimeoutMessage", factory.driver);
                    WaitForVisibility(5, element);
                    String text = element.getText();
                    if (text.equals("Your Session has timed out. Please login again.")) {
                        Button.Instance().ClickButton("SessionTimeoutOkButton");
                        Login.Instance().loginvBate(GlobalVariables.Username, GlobalVariables.Password);

                    }

                } catch (Exception e) {
                    MyLogger.log.info("You are logged out due to some reason, logging in app again ");
                    launchApp();
                    Login.Instance().loginvBate(GlobalVariables.Username, GlobalVariables.Password);
                }
            }
        } else {
            MyLogger.log.info("Driver is null, need to initalize driver and logging app again");
            factory.getDriver();
            Login.Instance().loginvBate(GlobalVariables.Username, GlobalVariables.Password);
        }
    }

    @Then("Is Control {string} enabled")
    public boolean IsControlEnabled(String Key) {
        boolean IsEnabled = IsControlEnabled(Key);
        return IsEnabled;

    }

/*    @And("Tap On Control {string} ")
    public void TapOnElement(String Key)
    {
            MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        GeneralHelper.Instance().TapOnElement(element);
    }*/

    public void verticalScroll() {
        //   factory.driver.findElement()
        Dimension size = factory.driver.manage().window().getSize();
        int y_start = (int) (size.height * 0.60);
        int y_end = (int) (size.height * 0.30);
        int x = size.width / 2;
        // TouchAction action = new TouchAction(factory.driver).longPress(x,size).moveTo(x, y_end).release();
        // action.perform();
    }


    @And("Clear textFields {string}")
    public void clearTextField(String value) {

        MobileElement element = ElementFinder.Instance().FindElement(value, factory.driver);
        element.clear();
        //  ElementFinder.Instance().FindElement(value, factory.driver).clear();

    }


    @And("Wait for <TimeInMilliseconds>")
    public void waitForTimeInMilliseconds() {
    }

    @And("Wait for {string}")
    public void waitFor(String arg0) {
    }

    @And("Tap On Control {string}")
    public void tapOnControl(String Key) {
        MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        GeneralHelper.Instance().TapOnElement(element);

    }

    @And("validateToastMessage {string} expectedResult {string}")
    public void ToasterMessage(String val, String expectedResult) {
        General.Instance().Wait(200);
        String element = ElementFinder.Instance.FindElement(val, factory.driver).getText();
        if (element != null) {

            if (element.equals(expectedResult)) {
                MyLogger.log.info("Toast Message is successfully Validate" + " -- " + element);
            } else {
                MyLogger.log.info("Toast Message is not correct");
                Assert.fail();
            }
        } else {
            MyLogger.log.info("element is null, cannot validate the toast message");
            Assert.fail();
        }

    }


 /*   @Given("SwapScreen yCordinate {int} endCordinate {int}")
    public void swapScreen(int yCordinate, int endCordinate) {

        Dimension dimension= factory.driver.manage().window().getSize();
        System.out.println(dimension.height+" and width is "+ dimension.width);
        int startx = dimension.getWidth() / 2;
        int starty = (int) (dimension.getHeight() * 0.8);
        int endy = (int) (dimension.getHeight() * 0.2);


        TouchAction action = new TouchAction(factory.driver);
        action.press(PointOption.point(startx,starty)).waitAction().moveTo(PointOption.point(startx,endy)).release(
        ).perform();

    }*/

    @Given("SwapScreen yCordinate {double} endCordinate {double}")
    public void swapscreenYCordinateEndCordinate(double yCordinate, double endCordinate) {
        Dimension dimension = factory.driver.manage().window().getSize();
        System.out.println(dimension.height + " and width is " + dimension.width);
        int startx = dimension.getWidth() / 2;
        int starty = (int) (dimension.getHeight() * yCordinate);
        int endy = (int) (dimension.getHeight() * endCordinate);


        TouchAction action = new TouchAction(factory.driver);
        action.press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(startx, endy)).release(
        ).perform();
    }
/*
    @Given("Fill Multiple Symbols")
    public void fillMultipleSymbols() {
    }*/

    @And("GetListVal")
    public void GetListVal() {
        String a = "Order ID: 2"; /// last element in the list
        Boolean found_result = false;


        Set<String> emptyList = new HashSet<>();
        while (!found_result) {
            //Dimension dimension= factory.driver.manage().window().getSize();
            // System.out.println(dimension.height+" and width is "+ dimension.width);
            List<MobileElement> ele = factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));
            int size = 0;
            size = size + ele.size();

            boolean found = false;
            for (int i = 0; i < size; i++) {

                String s = ele.get(i).getText();
                emptyList.add(s);

                //System.out.println(s);
                if (s.equals(a)) {
                    found = true;
                    //System.out.println(size);
                    break;
                }
            }

          if (found) {
                found =true;
               // System.out.println(size);
                break;
            }
            if (!found) {
                Dimension dimension = factory.driver.manage().window().getSize();
                //  System.out.println(dimension.height+" and width is "+ dimension.width);
                int startx = dimension.getWidth() / 2;
                int starty = (int) (dimension.getHeight() * 0.8);
                int endy = (int) (dimension.getHeight() * 0.2);
                TouchAction action = new TouchAction(factory.driver);
                action.press(PointOption.point(startx, starty)).waitAction().moveTo(PointOption.point(startx, endy)).release(
                ).perform();
            }
        }

        List<String> itemList = new ArrayList<>(emptyList);
     //   System.out.println(emptyList);

        for (int j = 0; j < itemList.size(); j++) {
            System.out.println(itemList.get(j));
        }
     /*   Set<String> set = new LinkedHashSet<>();
        set.addAll(emptyList);
        emptyList.clear();
        System.out.println(emptyList+"final orders");*/
        // convert the arraylist into a set


        // delete al elements of arraylist


          /*     List<String> finalList= new ArrayList<>(emptyList);
               for (int k=0; k<finalList.size();k++){
                   finalList.removeIf(s -> Boolean.parseBoolean(s));
*/
    }
    /*        System.out.println(finalList);*/


}




