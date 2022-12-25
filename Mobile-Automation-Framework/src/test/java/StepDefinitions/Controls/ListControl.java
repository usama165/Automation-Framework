package StepDefinitions.Controls;

import StepDefinitions.ClassSpecificMethods.Locates;
import StepDefinitions.ClassSpecificMethods.Position;
import com.appium.Main.DriverClasses.AndroidList;
import com.appium.Main.DriverClasses.ElementFinder;
import com.appium.Main.DriverClasses.GeneralHelper;
import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.App;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class ListControl
{

    public static ListControl Instance=null;
    public static ListControl Instance() {
        {
            if (Instance == null)
            {
                Instance = new ListControl();

            }
            return Instance;
        }
    }

}
