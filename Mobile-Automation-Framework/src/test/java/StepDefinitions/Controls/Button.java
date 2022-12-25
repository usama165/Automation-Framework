package StepDefinitions.Controls;

import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.Factory.factory;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofMillis;

public class Button
{
    public static Button Instance=null;
    public static Button Instance()
    {
        {
            if(Instance== null)
            {
                Instance = new Button();
            }
            return Instance;
        }
    }
    @And("Get Button Text {string}")
    public String GetButtonText(String Key)
    {   String FoundText="";
        MobileElement element= ElementFinder.Instance().FindElement(Key, factory.driver);
        if(element == null)
        {
            Assert.fail();
        }
        else
        {
             FoundText= element.getText();
        }

       return FoundText;
    }

    @And("Click Button {string}")
    public void ClickButton(String Key)
    {
        MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        element.click();
        MyLogger.log.info(Key+ "Button has been clicked");

    }

    @And("Click Button with Action {string}")
    public void ClickButtonWithAction(String Key)
    {
        MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        TouchActions action = new TouchActions(factory.driver);
        action.moveToElement(element);

        /*TouchAction action=new TouchAction(factory.driver);
        action.tap(tapOptions().withElement(element(element)))
                .waitAction(waitOptions(ofMillis(250))).perform();
*/
        /* ElementFinder.Instance().MoveToElement(element);*/
       // element.click();
        MyLogger.log.info(Key+ "Button has been clicked");

    }




}
