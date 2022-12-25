package com.appium.Main.JsonClasses;

import com.appium.Main.Logger.MyLogger;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.IOException;

public class ParseLocators extends ReadFile {

    public static String key;
    public static String locator;

    public static String value;
 public ParseLocators(String locator, String value)
 {
     this.locator=locator;
     this.value=value;
 }
 static FileReader reader;
 public static JSONObject GetLocatorObject(String key) throws IOException

 {
     if(App.key.equals("iOS"))
         {
             reader= GetJsonFile(GlobalVariables.iOSLocatorsFile);
         }
    else if (App.key.equals("Android"))
         {
             reader= GetJsonFile(GlobalVariables.AndroidLocatorsFile);
         }
    else
         {
             MyLogger.log.error(key+" File not found");
         }

        JSONObject jsonObject= JsonHelper.Instance().ParseJson(reader);
        JSONObject obj = (JSONObject) jsonObject.get(key);
        reader.close();
        return obj;
    }

    public static ParseLocators GetValues(String Key)
    {
        JSONObject jsonObject = null;
        try
        {
            jsonObject = GetLocatorObject(Key);
        }
        catch (Exception e)
        {
            MyLogger.log.error(Key+" Key is not found in "+App.key+ " JSON file");
        }

        ParseLocators KeyObject = null;
        String locator = jsonObject.get("locator").toString();
        String value = jsonObject.get("value").toString();
        KeyObject = new ParseLocators(locator, value);
        return KeyObject;
    }

    public static String[] SplitLocatorValue(String Key, String SplitBy){
     String XPATH;
     ParseLocators obj = GetValues(Key);
     XPATH =obj.value;
     String[] arr = XPATH.split(SplitBy);
     return arr;
    }

}
