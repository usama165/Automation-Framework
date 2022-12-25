package StepDefinitions.ClassSpecificMethods;

import StepDefinitions.Controls.General;
import StepDefinitions.Controls.Button;
//import StepDefinitions.Controls.General;
import StepDefinitions.Controls.Textbox;
import com.appium.Main.DriverClasses.Android;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.DriverClasses.iOS;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.JsonClasses.GlobalVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class Login
{
    public static Login Instance=null;
    public static Login Instance() {
        {
            if (Instance == null) {
                Instance = new Login();

            }
            return Instance;
        }
    }
    @Given("I am using the vBate")
    public void iAmUsingTheVBate()
    {
      factory.getDriver();
    }
    @When("I add Verification code{string}")
    public void iAddVerificationCode(String Code) {
String Result;
        if(App.key.equals("iOS"))
        {
            Result= iOS.iosDriver.SubmitVerificationCode(Code);
            Assert.assertEquals(GlobalVariables.Success,Result);
        }
        else
        {
            Result= Android.androidDriver.SubmitVerificationCode(Code);
            Assert.assertEquals(GlobalVariables.Success,Result);

        }

    }

    @Given("Login vBate with {string} {string}")
    public void loginvBate(String Username, String Password){
     //   Button.Instance().ClickButton("LoginBtnSplash");
        General.Instance().Wait(5000);
      //  General.Instance().clearTextField("Username");
      //  General.Instance().clearTextField("Password");
        General.Instance().CheckPresenceOfElement("Username");
        String Name= Username + "," +Password;

        Textbox.Instance().FillMultipleTextBox("Username,Password" ,Name);
        General.Instance().Wait(5000);
        Button.Instance().ClickButton("LoginButton");
        General.Instance().Wait(7000);
        iAddVerificationCode("123456");
        Button.Instance().ClickButton("VerifyButton");

    }

    @Then("User will be logged in")
    public void userWillBeLoggedIn() {
    }
}
