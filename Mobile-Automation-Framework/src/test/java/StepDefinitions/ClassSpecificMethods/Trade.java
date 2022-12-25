package StepDefinitions.ClassSpecificMethods;
import StepDefinitions.Controls.Button;
import StepDefinitions.Controls.General;
import StepDefinitions.Controls.Labels;
import com.appium.Main.DriverClasses.Android;
import com.appium.Main.Factory.factory;
import StepDefinitions.Controls.Textbox;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class Trade {
    public static Trade Instance=null;
    public static Trade Instance()
    {
        {
            if (Instance == null) {
                Instance = new Trade();

            }
            return Instance;
        }
    }







    public void dropdown() {
       /* driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Auto Complete']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Screen Top']")).click();
        driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("India");

        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));

        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
        Thread.sleep(2000);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        Thread.sleep(2000);
        String text = driver.findElementById("io.appium.android.apis:id/edit").getText();
        System.out.println("Text Found : " + text);
        if (text.equals("India")) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }*/
//
//    }
//
//}


    }

    @And("validateBidAskValue last {string} , bid {string}, ask {string}")   //, bid {string}, ask {string}
    public void validatebidaskvalueLastBidAsk(String last, String bid, String ask) {
        String lastPrice= Labels.Instance().GetText(last);
        String bidPrice=Labels.Instance().GetText(bid);
        String askPrice=Labels.Instance().GetText(ask);

        General.Instance.Wait(3000);


        // MyLogger.log.info(lastPrice);

        if(lastPrice.equals("$0") || bidPrice.equals("$0") || askPrice.equals("$0")){
            MyLogger.log.info("The market data is not present and may be the market is closed at this time");
            // , String bid, String ask

        }
        else if (lastPrice.equals("-") || bidPrice.equals("-") || askPrice.equals("-")){
            MyLogger.log.info("The market data is not present and may be the market is closed at this time");
        }


        else {
            MyLogger.log.info("Market data is present please enter right symbol or refresh the screen");
        }
    }


    @And("validatemarketDataagreementacceptedornot {string} buttonVal {string} regularPrice {string}")
    public void validatemarketdataagreementacceptedornot(String marketagree, String buttonVal, String regularPrice) {


  /*      String[] xpath = ParseLocators.SplitLocatorValue(marketagree, "/break/");
        String xpath2= xpath[0] +"Retry"+ xpath[1];

        MobileElement marketDataNotAvaliable = (MobileElement) factory.driver.findElementByXPath(xpath[0]);
        MobileElement marketDataAvaliable = (MobileElement) factory.driver.findElementByXPath(xpath[1]);*/
        //    MobileElement marketDataNotAvaliable = (MobileElement) factory.driver.findElementByXPath(marketagree);
        MobileElement  marketDataNotAvaliable= (MobileElement) factory.driver.findElement(By.xpath(marketagree));
        String MDNA=marketDataNotAvaliable.getText();
        // String MDA=marketDataAvaliable.getText();
        //boolean check= true;

        if (MDNA.equals("Retry")) {
            Button.Instance().ClickButton(buttonVal);
            General.Instance().Wait(5000);

            if (MDNA.equals("Retry")) {
                MyLogger.log.info("The market data agreement is not subscribed");
            }

        }
        else {
           /* String regularprice = Labels.Instance().GetText(regularPrice);
            MobileElement marketDataAvaliable = (MobileElement) factory.driver.findElementByXPath(xpath[1]);
            String MDA = marketDataAvaliable.getText();*/
            /*if (regularprice.equals(MDA)) {*/
            MyLogger.log.info("Market data is already subscribed");
        }
    }
      /*else
        {
            MyLogger.log.info("Something is wrong");
        }*/




    @And("getDropdownList {string} {string}")
    public void getDropdownList(String accountDropdownList, String accountDropdownValues) {


        // List<MobileElement> dropDownValues= ElementFinder.Instance.GetElementList(dropdownList, factory.driver);

       /* System.out.println(Android.androidDriver.getPageSource());
        MyLogger.log.info(Android.androidDriver.getPageSource());*/
        /*General.Instance.Wait(5000);
        TouchAction touchAction= new TouchAction(factory.driver);
        touchAction.tap(PointOption.point(736,2126)).perform();*/
        // List<MobileElement> elements = factory.driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\".*com.logiciel.vbate.android.app.qa:id/item_power_menu_title\")"));
        List<MobileElement> elements = factory.driver.findElements(By.xpath("//android.widget.FrameLayout[@resource-id='com.android.systemui:id/navigation_bar_frame']/following-sibling::android.widget.FrameLayout[2]//android.widget.TextView"));


        System.out.println("elements size: " + elements.size());
        TapOptions test;
        try {

            TouchAction action = new TouchAction(factory.driver);
            if(elements==null){
                MyLogger.log.info("Elements List is found to be null or empty.");
                return;
            }
            for(int i=0;i<=elements.size();i++){
                if(elements.get(i).getText()=="usama165 account 1"){
                    elements.get(i).click();
                }

            }
        }
        catch (Exception e)
        {             e.printStackTrace();
        }




    }

    @And("dropDownSpecificValue {string}")
    public void getdropdownSpecificValue(String checkvalue) {
        MobileElement element;
        element = ElementFinder.Instance().FindElement(checkvalue, factory.driver);
        String foundText=element.getText();
        MyLogger.log.info("Text set for "+checkvalue+" element is "+foundText);

    }


    @And("getDropdownThroughtCoordinates")
    public void getdropdownthroughtcoordinates() {
        //  TouchAction touchAction= new TouchAction(factory.driver);
        //  touchAction.tap(PointOption.point(736,2126)).perform();
        // touchAction.tap(PointOption.point(534,1913)).perform();
        MobileElement element= (MobileElement) factory.driver.findElement ( new MobileBy.ByAndroidUIAutomator("new UiSelector().textContains(\"usama165 account 1\")"));
        System.out.println(element.getText());
        element.click();
        // MobileElement element=(MobileElement) factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().resourseId(\"com.logiciel.vbate.android.app.qa:id/item_power_menu_title\").scrollable(true)).setAsVerticalList().scrollIntoView(new UiSelector().text(\"usama165 account 1\"))"));
        //   factory.driver.findElement( new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"usama165 account 1\"));")).click();
        //  factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("Uiselector().clickable(true).(1)).click();"));
        //  touchAction.moveTo(1913).release();
        //   factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("UiSelector().resourseId(\"com.nnacres.app:id/sectionShortlist\")")).findElement(By.id("")).click();
        //  dr.scrollToExact("usama165 account 1");
        //  dr.findElement(By.id("com.nnacres.app:id/sectionShortlist")).click();


    }

    //   @And("scrollToSendOrder")
    //  public void scrolltoSendOrder(){
    // String element1= textVal;
    //     MobileElement element= (MobileElement) factory.driver.findElement ( new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"yourtext\"));"));
    //  MobileElement element= (MobileElement) factory.driver.findElement ( new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\" + element1 + \");"));
    //  MobileElement element= (MobileElement) factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiSelector().text(\"\"+element1+\"\")"));
    // factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(' + textVal + '));"));
    //Order ID: 22
    // MobileElement element= (MobileElement) factory.driver.findElement( new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Order ID: 8\"));"));

            /* String mySelector = "new UiSelector().text(\"" + element1 + "\").instance(0)";

      String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + mySelector + ");";
      factory.driver.findElement(new MobileBy.ByAndroidUIAutomator(command));*/


    /*((AndroidDriver<MobileElement>) AppDriver.getDriver()).findElementByAndroidUIAutomator(


    "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + Text + "\").instance(0))").click();


    */
    //   }
    @And("scrollToSendOrderOut {string}")
    public void scrollToSendOrderOut(String textVal) {
        String orderID = textVal;
        if(orderID == null)
        {
            MyLogger.log.info("String Value is not found" + orderID);
        }
        else
        {
            MobileElement element = (MobileElement) factory.driver.findElement(new MobileBy.ByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"" + orderID + "\"))"));
        }




        /*MobileElement element1 = (MobileElement) factory.driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"+".scrollIntoView(new UiSelector().text(\"Order ID: 8\"))"));*/
        //   MobileElement element= (MobileElement) factory.driver.findElement ( new MobileBy.ByAndroidUIAutomator(
        //  "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Order ID: 8\"));"));
    }

    @And("getALLOrdersist")
    public void getALLOrdersist(){
       /* MobileElement resource = (MobileElement) factory.driver.findElement(By.id("com.xxx.verify.xxxtestapp:id/oauth2_resource_edittext"));
        MobileElement openid = (MobileElement) factory.driver.findElement(By.id("com.xxx.verify.xxxtestapp:id/oauth2_scope_edittext"));
        TouchAction action = new TouchAction(factory.driver);
        action.press(resource).moveTo(openid).release();
        action.perform();
*/

// Import necessary libraries

// Create an instance of the TouchAction class
        TouchActions touchAction = new TouchActions(factory.driver);

// Scroll the screen using the TouchAction instance
        touchAction.scroll(563, 1758).perform();

// Locate the elements containing the values you want to retrieve
        List<MobileElement> valueElements = factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));

// Iterate over the elements and retrieve the values
        List<String> values = new ArrayList<String>();
        for (MobileElement element : valueElements) {
            System.out.println(values.add(element.getText()));
        }

        // Create an instance of the JavaScriptExecutor class
 /*       JavascriptExecutor jsExecutor = (JavascriptExecutor) factory.driver;

// Define a JavaScript function to scroll the list
        String scrollListFunction = "arguments[0].scrollIntoView(true);";

// Locate the list element
        MobileElement listElement = (MobileElement) factory.driver.findElement(By.className("android.view.ViewGroup"));

// Scroll the list into view
        jsExecutor.executeScript(scrollListFunction, listElement);

// Locate the elements in the list
        List<MobileElement> listElements = listElement.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));

// Iterate over the elements and retrieve the values you want
        for (MobileElement element : listElements) {
            String value = element.getText();
            System.out.println(value);
            // Do something with the value
        }*/
        // Initialize the TouchAction class
        //TouchAction action = new TouchAction(factory.driver);

// Scroll down the list by swiping from the top of the list to the bottom
       /* action.press(PointOption.point(563, 590))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(900)))
                .moveTo(PointOption.point(605, 1704))
                .release()
                .perform();*/
// Get the list of elements
/*        List<MobileElement> elements = factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));

// Create a JavaScriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) factory.driver;

// Iterate through the list of elements and get their text values
        for (MobileElement element : elements) {
            String text = (String) js.executeScript("return arguments[0].innerText;", element);
            System.out.println(text);
        }*/
 /*       // First, locate the list elements on the screen
        List<MobileElement> listElements = factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));

// Create a new list to store the values
        List<String> listValues = new ArrayList<>();

// Scroll through the list and get the text of each element
        for (MobileElement element : listElements) {
            // Scroll to the element
            ((JavascriptExecutor)factory.driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Get the text of the element and add it to the list
            System.out.println(listValues.add(element.getText()));
        }*/


        //  String text="Order";
        // factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("UiSelector().resourseId(\"com.nnacres.app:id/sectionShortlist\")")).findElement(By.id("")).click();
   /*     List<MobileElement> elements = (List<MobileElement>) factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\"com.logiciel.vbate.android.app.qa:id/orderID\"))" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));*/
        //   General.Instance.Wait(5000);
        /*Get me the some orders*/
        /*List<MobileElement> element12 =factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(20)"+".scrollIntoView(new UiSelector().resourceId(\"com.logiciel.vbate.android.app.qa:id/orderID\"))"));*/

      /*  List<MobileElement> element12 =factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setMaxSearchSwipes(20)"+".scrollIntoView(new UiSelector().resourceId(\"com.logiciel.vbate.android.app.qa:id/orderID\"))"));*//*

        List<MobileElement> element= (List<MobileElement>) factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*com.logiciel.vbate.android.app.qa:id/orderID.*\").scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Order ID\"));"));

        for(int i=0; i<element.size(); i++){
            System.out.println(element.get(i).getText());
        }*/

/*
        List<MobileElement> element1= (List<MobileElement>) factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(new UiSelector().textContains(\"Order ID\"));"));

        for(int i=0; i<element1.size(); i++){
            System.out.println(element1.get(i).getText());
        }*/
        /* Get me the whole order values*/
      /*  List<MobileElement> element12 =factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"+".scrollIntoView(new UiSelector().className(\"android.widget.TextView\"))"));*/
        /*List<MobileElement> list1 = factory.driver.findElements(new MobileBy.ByAndroidUIAutomator(
                "new UiSelector().className("+"android.view.ViewGroup"+").className(\"android.widget.TextView\")"));
*/


        //   resourceId

        /*MobileElement elements = (MobileElement) factory.driver.findElement(MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceIdMatches(\"com.logiciel.vbate.android.app.qa:id/orderID"))+
                         ".scrollIntoView(new UiSelector().text(\""+text+"\"))"));*/

    }

    @And("scrollToEndscrollToEnd")
    public void scrollToEnd() {

      /*  int orders1= factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).size();
        for(int i=0; i<orders1; i++){
            MobileElement element1 = (MobileElement) factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).get(i);
            System.out.println(element1.getText());

        }*/


    }

   /*     JavascriptExecutor js = (JavascriptExecutor) factory.driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject)*/;

    // General.Instance.Wait(5000);
        /*MobileElement element = (MobileElement)factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Order ID: 2\"));"));
        int orders= factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).size();
        for(int i=0; i<orders; i++){
            MobileElement element1 = (MobileElement) factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).get(i);
            System.out.println(element1.getText());
*/


    /*    MobileElement element2 = (MobileElement)factory.driver.findElement(new MobileBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Order ID: 36\"));"));
        int orders2= factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).size();
        for(int i=0; i<orders2; i++){
            MobileElement element3 = (MobileElement) factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID")).get(i);
            System.out.println(element3.getText());

        }*/

   /* @And("GetListVal")
    public void GetListVal(){
        String a = "Order ID: 2"; /// last element in the list
        Boolean found_result = false;

        while (!found_result){
            //Dimension dimension= factory.driver.manage().window().getSize();
            // System.out.println(dimension.height+" and width is "+ dimension.width);
            List<MobileElement> ele = factory.driver.findElements(By.id("com.logiciel.vbate.android.app.qa:id/orderID"));
            int size=0;
            size = size+ele.size();

            boolean found = false;
            for (int i = 0; i < size; i++) {

                String s = ele.get(i).getText();
                System.out.println(s);
                if (s.equals(a)) {

                    found =true;

                    System.out.println(size);
                    break;

                }}
            if (found) {

                found =true;

                System.out.println(size);
                break;
            }

            if(!found){

                Dimension dimension= factory.driver.manage().window().getSize();
                System.out.println(dimension.height+" and width is "+ dimension.width);
                int start_x= (int) (dimension.width * 0.49);
                int start_y= (int) (dimension.height * 0.24);

                int end_x= (int) (dimension.width * 0.52);
                int end_y= (int) (dimension.height * 0.52);


                TouchAction action=new TouchAction(factory.driver);
                action.press(PointOption.point(start_x,start_y)).waitAction(
                                WaitOptions.waitOptions(Duration.ofSeconds(1))).
                        moveTo(PointOption.point(end_x,end_y)).release().perform();


            }

        }

    }*/
    @And("checkListValues")
    public void checkListValues(){
        List<MobileElement> ele = ElementFinder.Instance.GetElementList("com.logiciel.vbate.android.app.qa:id/orderID", factory.driver);
        for (int i=0 ; i< ele.size(); i++){
            System.out.println(ele.get(i).getText());
        }


    }

}

 /*   @And("createOrder {string}")
    public void createOrder(DataTable table){
        java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
        if(data.isEmpty()){
            MyLogger.log.info("symbols list not found");
        }
        else {
            for (int i = 0; i < data.size(); i++)
            {


                // General.Instance().Wait(1000);
                Textbox.Instance().FillTextBox("SymbolField", data.get(i).get("Symbol"));
                Button.Instance().ClickButton("AddSymbolIcon");
                MyLogger.log.info("Symbol Added");
            }
        }

    }*/




       /* if(fail != 0)
        {
            Assert.fail();
        }*/





  /*      @And("test the line")
    public void testing(){
            Android an=new Android();
            an.test();

        }*/


