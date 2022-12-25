package StepDefinitions.ClassSpecificMethods;

import StepDefinitions.Controls.General;
import com.appium.Main.DriverClasses.AndroidList;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.DriverClasses.GeneralHelper;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.App;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class Position
{
    public static Position Instance=null;
    public static Position Instance() {
        {
            if (Instance == null) {
                Instance = new Position();

            }
            return Instance;
        }
    }
    @Then("Get index of position of Symbol {string}, Position {string} and Account {string}")
    public void GetGridIndexValue(String Symbol,String Position, String AccountValue)
    {
        General.Instance().Wait(5000);
        if(App.key.equals("Android"))
        {
            AndroidList.Instance().GetGridIndexValue(Symbol,Position,AccountValue);
        }
        else{
            //List methods are pending for iOS
            MobileElement e= (MobileElement) factory.driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"vBate\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView");
            java.util.List<MobileElement> List= e.findElementsByXPath("//XCUIElementTypeButton");
            System.out.println(List.size());
            int index=-1;
            for(MobileElement el:List)
            {
                index++;
                System.out.println(index);
                java.util.List<MobileElement> List2= factory.driver.findElementsByXPath("//XCUIElementTypeStaticText");
                for(MobileElement el1:List2)
                {
                    System.out.println(el1.getText());
                }
            }
        }
    }
    @Then("Validate Values of Position List Symbol {string}, Position {string} and Account {string}")
    public void ValidatePositionRowValues(String Symbol,String Position, String AccountValue, DataTable table)
    {
        General.Instance().Wait(5000);
        if(App.key.equals("Android"))
        {
            AndroidList.Instance().ValidatePosition(Symbol,Position,AccountValue,table);
        }
    }

    @Then("Click on menu icon on Position Screen of Symbol {string}, Position {string} and Account {string}")
    public void ClickOnPositionMenuIcon(String Symbol,String Position, String AccountValue){
        General.Instance().Wait(5000);
        if(App.key.equals("Android"))
        {
            int index=  AndroidList.Instance().GetGridIndexValue(Symbol,Position, AccountValue);
            List<MobileElement> List = ElementFinder.Instance().GetElementList("PositionList",factory.driver);
            ElementFinder.Instance().FindElement("PositionMenuIcon",List.get(index)).click();
        }

    }

    @And("Select Position Menu Option {string}")
    public void SelectPositionMenuOption(String Option)
    {
        List<MobileElement> List= ElementFinder.Instance().GetElementList("PositionMenuOptionText",factory.driver);
        System.out.println(List.size());
        for(MobileElement e: List)
        {
            System.out.println(e.getText());
            if(e.getText().equals(Option))
            {
                GeneralHelper.Instance().TapOnElement(e);
                break;
            }
        }
    }
}
