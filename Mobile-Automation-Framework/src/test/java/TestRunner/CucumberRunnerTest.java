//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package TestRunner;

import StepDefinitions.ClassSpecificMethods.Login;
import StepDefinitions.Controls.General;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.GlobalVariables;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/java/Features/Test/watchlistCases.feature"},
        glue = {"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//        tags = "@reg"
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    public CucumberRunnerTest() {
    }

    @BeforeTest
    public void setup() {
        GlobalVariables.Instance().SetGlobalVariables();
        Login.Instance().iAmUsingTheVBate();
        Login.Instance().loginvBate(GlobalVariables.Username, GlobalVariables.Password);
    }

    @AfterTest
    public void quit() {
        General.Instance().Wait(5000);
        factory.driver.quit();
    }
}
