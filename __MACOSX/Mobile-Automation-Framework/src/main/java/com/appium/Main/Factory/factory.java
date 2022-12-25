package com.appium.Main.Factory;

import com.appium.Main.DriverClasses.Android;
import com.appium.Main.DriverClasses.iOS;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.JsonClasses.GlobalVariables;
import com.appium.Main.Logger.MyLogger;
import com.appium.Main.Setup.Capabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class factory {
    private static Capabilities caps = null;

    public static AppiumDriver driver=null;
    public static DesiredCapabilities capabilities = null;
    public static AppiumDriver<MobileElement> getDriver() {
        try {
            GetCap();
            if (App.key.equals("iOS"))
            {
                iOS.iosDriver = new iOS(new URL(GlobalVariables.iOSServerURL), capabilities);
                driver = iOS.iosDriver;
                MyLogger.log.info("IOS Driver is set");

            }
            else if (App.key.equals("Android"))
            {
                Android.androidDriver = new Android(new URL(GlobalVariables.AndroidServerURL), capabilities);
                driver = Android.androidDriver;
                MyLogger.log.info("Android Driver is set");

            }
            else
            {
                MyLogger.log.error("Driver Key is undefined. Unable to set the driver");
            }
        }
        catch(Exception ex)
        {
            MyLogger.log.error(ex);
        }

        return driver;
    }

    public static Capabilities GetCap()
    {
        if (caps == null)
        {
            caps = new Capabilities();
        }

        return caps;
    }
    public static DesiredCapabilities CreateDesiredCapabilitiesInstance()
    {
        if (driver == null)
        {
            capabilities = new DesiredCapabilities();

        }

        return capabilities;
    }


}
