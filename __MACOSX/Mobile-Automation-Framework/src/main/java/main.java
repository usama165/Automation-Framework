import com.appium.Main.DriverClasses.Android;
import com.appium.Main.Factory.factory;
import com.appium.Main.File.TextFileHelper;
import com.appium.Main.JsonClasses.GlobalVariables;
import io.appium.java_client.android.Activity;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String args[])
    {
        GlobalVariables.Instance().SetGlobalVariables();
        factory.getDriver();
        Android.androidDriver.startActivity(new Activity("com.android.chrome", "com.google.android.apps.chrome.Main"));
    }
}