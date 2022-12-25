package com.appium.Main.Setup;

import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class Capabilities extends DesiredCapabilities {
    private AppiumDriverLocalService service;
    public Capabilities(){
    App.ParseAppJson();
    String Key= App.key;
    if(Key.equals("iOS") )
    {
       factory.capabilities = factory.CreateDesiredCapabilitiesInstance();
       factory.capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, App.PlatformName);
       factory.capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, App.PlatformVersion);
       factory.capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, App.DeviceName);
       factory.capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, App.AutomationName);
       factory.capabilities.setCapability(MobileCapabilityType.UDID, App.Udid);
       factory.capabilities.setCapability(MobileCapabilityType.APP, App.App);

    }
    else if (Key.equals("Android"))
    {

        DesiredCapabilities capabilities = factory.CreateDesiredCapabilitiesInstance();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, App.DeviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,App.PlatformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,App.PlatformVersion);
        capabilities.setCapability("appPackage",App.appPackage);
        capabilities.setCapability("appActivity",App.appActivity);
    //    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

    }
    else
    {
        MyLogger.log.error("Invalid Driver Key, Unable to set driver capabilities");

    }
}

    public void stopServer()
        {
            service.stop();
        }
    }

