package TestRunner;

import StepDefinitions.ClassSpecificMethods.Login;
import StepDefinitions.Controls.General;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.GlobalVariables;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

  @Before
   public void setup()
  {
       GlobalVariables.Instance().SetGlobalVariables();
       Login.Instance().iAmUsingTheVBate();
       Login.Instance().loginvBate(GlobalVariables.Username,GlobalVariables.Password);
  }
  @After
    public void quit()
  {
      General.Instance().Wait(5000);
     // factory.driver.quit();
  }
}
