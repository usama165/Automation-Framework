package com.appium.Main.JsonClasses;

import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class App extends ReadFile {
    public static String key;
    public static String App;
    public static String PlatformName;
    public static String PlatformVersion;
    public static String DeviceName;
    public static String Udid;
    public static String AutomationName;

public static String appPackage;
public static String appActivity;
    public static void ParseAppJson() {

        FileReader reader= GetJsonFile(GlobalVariables.AppJsonFile);
        JSONObject obj= JsonHelper.Instance().ParseJson(reader);

        key= obj.get("Key").toString();

        switch(key)
        {
            case "iOS":
            {
                App= obj.get("App").toString();
                PlatformName= obj.get("Platform_Name").toString();
                PlatformVersion= obj.get("Platform_Version").toString();
                DeviceName= obj.get("DeviceName").toString();
                Udid= obj.get("Udid").toString();
                AutomationName= obj.get("AutomationName").toString();
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Android":
            {
                PlatformName= obj.get("Platform_Name").toString();
                PlatformVersion= obj.get("Platform_Version").toString();
                DeviceName= obj.get("DeviceName").toString();
                appPackage= obj.get("appPackage").toString();
                appActivity= obj.get("appActivity").toString();
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    throw new RuntimeException(e);
                }
                break;
            }
            default:
            {
                System.out.println("Driver Caps not set");
            }
        }

    }

}
