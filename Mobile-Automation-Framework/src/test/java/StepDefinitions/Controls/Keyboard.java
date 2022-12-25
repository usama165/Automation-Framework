package StepDefinitions.Controls;

import com.appium.Main.DriverClasses.Android;
import com.appium.Main.DriverClasses.iOS;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.App;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class Keyboard {

    public static Keyboard Instance=null;
    public static Keyboard Instance() {
        {
            if (Instance == null) {
                Instance = new Keyboard();

            }
            return Instance;
        }
    }
    @Then("Hide Keyboard")
    public void HideKeyboard()
    {
        boolean isKeyboardShown;
        if(App.key.equals("iOS")){
           isKeyboardShown = iOS.iosDriver.isKeyboardShown();
          System.out.println(isKeyboardShown);
        }
        else{
            isKeyboardShown = Android.androidDriver.isKeyboardShown();
        }
        System.out.println(isKeyboardShown);

        if(isKeyboardShown==true)
        {
            factory.driver.hideKeyboard();
        }
    }



}
