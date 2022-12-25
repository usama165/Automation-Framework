package StepDefinitions.Controls;

import com.appium.Main.DriverClasses.AndoridComboBox;
import com.appium.Main.DriverClasses.iOSComboBox;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.Logger.MyLogger;
import io.cucumber.java.en.Given;

public class ComboBox
{
    public static ComboBox Instance=null;
    public static ComboBox Instance() {
        {
            if (Instance == null) {
                Instance = new ComboBox();

            }
            return Instance;
        }
    }

    @Given("Select ComboBoxValue {string} {string}")
    public void SelectComboBoxValue(String ComboBoxType, String Value)
    {
        if(App.key.equals("iOS"))
        {
            iOSComboBox.Instance().SelectComboValue(ComboBoxType, Value);
        }
        else
        {
            AndoridComboBox.Instance().SelectComboValue(ComboBoxType, Value);
        }

    }

    @Given("Select Multiple CheckBoxValues {string} {string}")
    public void FillMultipleTextBox(String ComboBoxType, String Value){
        try
        {
            Thread.sleep(5000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

        String[] ComboBoxTypeList = ComboBoxType.split(",");
        String[] ValueList = Value.split(",");

        if(ComboBoxTypeList.length==ValueList.length)
        {
            for(int i=0;i<ComboBoxTypeList.length;i++)
            {
                SelectComboBoxValue(ComboBoxTypeList[i],ValueList[i]);
            }
        }

        else
        {
            MyLogger.log.error("Input size of Keys "+ComboBoxTypeList+" are different from input size of Values" +ValueList+ "Give value against each key");
        }
    }
}
