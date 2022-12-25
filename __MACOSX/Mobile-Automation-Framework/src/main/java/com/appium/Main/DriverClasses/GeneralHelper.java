package com.appium.Main.DriverClasses;

import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.GlobalVariables;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class GeneralHelper
{
    public static GeneralHelper Instance=null;
    public static GeneralHelper Instance(){
        {
            if(Instance== null)
            {
                Instance = new GeneralHelper();

            }
            return Instance;
        }
    }

    public void Wait(int TimeInMilliseconds){
        try
        {
            Thread.sleep(TimeInMilliseconds);
        }
        catch (InterruptedException e)
        {
            MyLogger.log.error(e);
            throw new RuntimeException(e);
        }
    }

    public  void WaitForVisibility(int TimeInSeconds, MobileElement element)
    {
        WebDriverWait wait = new WebDriverWait(factory.driver, TimeInSeconds);
        try
        {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch(Exception ex)
        {
            MyLogger.log.error(ex);
        }
    }

    public  void WaitUntilAlertIsPresent()
    {
        WebDriverWait wait = new WebDriverWait(factory.driver, 5);
        try
        {
            wait.until(ExpectedConditions.alertIsPresent());
        }
        catch (Exception ex)
        {
            MyLogger.log.error(ex);
        }
    }

    public void LogMessage(String LoggingType, String Message){
        switch (LoggingType)
        {
            case "Debug":
            {
                MyLogger.log.debug(Message);
                break;
            }
            case "Info":
            {
                MyLogger.log.info(Message);
                break;
            }
            case "Error":
            {
                MyLogger.log.error(Message);
                break;
            }
            case "Warn":
            {
                MyLogger.log.warn(Message);
                break;
            }
            default:
            {
                MyLogger.log.error("Invalid Log type requested i.e. " +LoggingType+"");
            }
        }


    }

    public void CheckPresenceOfElement(String Key) {
        String Result;
        MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        WaitForVisibility(10,element);
        boolean IsPresent = element.isDisplayed();
        if (IsPresent == true)
        {
            Result= "Success";
            MyLogger.log.info(Key+" Control is present");
        }
        else
        {
            Result="Fail";
            MyLogger.log.info(Key+" Control is not present");
        }

        Assert.assertEquals(GlobalVariables.Success,Result);
    }
    public void closeApp()
    {
        ((InteractsWithApps) factory.driver).closeApp();
    }
    public void launchApp()
    {
        ((InteractsWithApps) factory.driver).launchApp();
    }

    public boolean IsControlEnabled(String Key)
    {
        MobileElement element = ElementFinder.Instance().FindElement(Key, factory.driver);
        boolean isEnabled = element.isEnabled();

        if(isEnabled == true)
        {
            MyLogger.log.info("Control is enabled");
            return true;
        }

        else
        {
            MyLogger.log.info("Control is disabled");
            return false;
        }


    }

    public String[] ConvertStringToStringArray(String Value, String SplitBy)
    {
        String[] ConvertedArray = Value.split(SplitBy);
        return ConvertedArray;
    }
    public void TapOnElement(MobileElement element)
    {
        try
        {
            TouchAction action = new TouchAction(factory.driver);
            action.tap(new TapOptions().withElement(new ElementOption().withElement(element))).perform();
        }
        catch(Exception ex)
        {
            if(element==null)
            {
                MyLogger.log.error("Element is null, unable to tap on the element");
            }
            else
            {
                MyLogger.log.error(ex);
            }

            Assert.fail();
        }

    }
}
