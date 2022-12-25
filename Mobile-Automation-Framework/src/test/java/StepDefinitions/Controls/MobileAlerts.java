package StepDefinitions.Controls;

import com.appium.Main.DriverClasses.Android;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.Factory.factory;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MobileAlerts {
    public static MobileAlerts Instance=null;
    public static MobileAlerts Instance() {
        {
            if (Instance == null)
            {
                Instance = new MobileAlerts();
            }
            return Instance;
        }
    }

    @Then("Accept Alert")
    public void AcceptAlert()
    {
        try
        {
            General.Instance().WaitUntilAlertIsPresent();
            Alert alert = factory.driver.switchTo().alert();
            alert.accept();
        }
        catch(Exception ex)
        {
            MyLogger.log.error("Unable to perform accept action on alert due to following exception");
            MyLogger.log.error(ex);
            Assert.fail();
        }
    }

    @Then("Get Alert Text")
    public String GetAlertText()
    {
        try
        {
            General.Instance().WaitUntilAlertIsPresent();
            Alert alert = factory.driver.switchTo().alert();
            String text = alert.getText();
            return text;
        }
        catch(Exception ex)
        {
            MyLogger.log.error("Unable to get the text of alert box due to following exception");
            MyLogger.log.error(ex);
            Assert.fail();
        }
        return "";
    }

    @Given("Validate Alert Text {string}")
    public boolean ValidateAlertText(String text)
    {
        String GetText= GetAlertText();
        if(GetText.equals(text))
        {
            return true;
        }
        return false;
    }

    @Then("Dismiss Alert")
    public void DismissAlert()
    {
        try
        {
            General.Instance().WaitUntilAlertIsPresent();
            Alert alert = factory.driver.switchTo().alert();
            alert.dismiss();
        }
        catch(Exception ex)
        {
            MyLogger.log.error("Unable to perform dismiss action on alert due to following exception");
            MyLogger.log.error(ex);
            Assert.fail();
        }

    }

// USAMA
    @And("Toast Alert")
    public void toastAlert() {
        try
        {

            String toast= Android.androidDriver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("delete");
           // MobileElement element= ElementFinder.Instance().FindElement(arg0, factory.driver);
           // String toast= element.getAttribute("delete");
            Assert.assertEquals(toast, "Please delete one existing symbol to add a new one");

        }
        catch(Exception ex)
        {
            MyLogger.log.error("Unable to perform dismiss action on alert due to following exception");
            MyLogger.log.error(ex);
            Assert.fail();
        }
    }
}
