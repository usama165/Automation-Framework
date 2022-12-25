package com.appium.Main.DriverClasses;

import com.appium.Main.Factory.factory;
import com.appium.Main.JsonClasses.ParseLocators;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementFinder
{
    public static ElementFinder Instance=null;
    public WebDriverWait wait = new WebDriverWait(factory.driver, 60);
    public static ElementFinder Instance()
    {
        {
            if(Instance== null)
            {
                Instance = new ElementFinder();
            }

            return Instance;
        }
    }
   int attempts= 3;
    public MobileElement FindElement(String Key, AppiumDriver driver)
    {
        MobileElement element= null;

        ParseLocators KeyObject=  ParseLocators.GetValues(Key);
try
{
    switch (KeyObject.locator)

    {
        case "Name":
        {
            element = (MobileElement) driver.findElementByName(KeyObject.value);
            wait.until(ExpectedConditions.visibilityOf(element));
         //MoveToElement(element);
            break;
        }

        case "XPath":
        {
            element = (MobileElement) driver.findElementByXPath(KeyObject.value);
            wait.until(ExpectedConditions.visibilityOf(element));
         //MoveToElement(element);
            break;
        }
        case "Class":
        {
            element = (MobileElement) driver.findElementByClassName(KeyObject.value);
            wait.until(ExpectedConditions.visibilityOf(element));
            //MoveToElement(element);
            break;
        }
        case "Id":
        {
            element = (MobileElement) driver.findElementById(KeyObject.value);
            wait.until(ExpectedConditions.visibilityOf(element));
           // MoveToElement(element);
            break;
        }
        case "LinkText":
        {
            element = (MobileElement) driver.findElementByLinkText(KeyObject.value);
            wait.until(ExpectedConditions.visibilityOf(element));
          //  MoveToElement(element);
            break;
        }
        default:
        {
            System.out.println("Element Not Found");

        }

    }
    if(element != null)
    {
        MyLogger.log.info(Key+" Element has found");
    }
}

catch (Exception e)
{
    if(element == null)
    {
        attempts--;
        if(attempts > 0)
        {
            MyLogger.log.info("Second Attempt to find the element");
            FindElement(Key, driver);

        }
        else
        {
        MyLogger.log.error(e);
        MyLogger.log.error("Cannot find an element "+Key+" using "+KeyObject.locator+" Locator strategy");
        attempts=2;
        return element;
        }
    }
}
        attempts=3;
        return element;
    }

   public List<MobileElement> GetElementList(String Key, AppiumDriver driver){
       List<MobileElement> element= null;
       ParseLocators KeyObject=  ParseLocators.GetValues(Key);
try
{

    switch (KeyObject.locator)
    {
        case "Name":
        {
            element = (List<MobileElement>) driver.findElementsByName(KeyObject.value);
            break;
        }

        case "XPath":
        {
            element = (List<MobileElement>) driver.findElementsByXPath(KeyObject.value);
            break;
        }
        case "Class":
        {
            element = (List<MobileElement>) driver.findElementsByClassName(KeyObject.value);
            break;
        }
        case "Id":
        {
            element = (List<MobileElement>) driver.findElementsById(KeyObject.value);
            break;
        }
        default:
        {
            MyLogger.log.error("Given Locate Searching Strategy i.e. " + KeyObject.locator + "is not defined in the scope");
        }
    }
}

catch (Exception e)
{
    if(element == null)
    {
        MyLogger.log.error(e);
        MyLogger.log.error("Cannot find an element "+Key+" ");
        return element;
    }
}

       return element;
    }
       public void MoveToElement(MobileElement element)

       {
           try
           {
               Actions action = new Actions(factory.driver);
               action.moveToElement(element);
               action.perform();
           }

           catch(Exception ex)
           {
               if(element==null)
               {
                   MyLogger.log.error("Element is null, Must provide a location for a move action.");
               }

               else
               {
                   MyLogger.log.error(ex);

               }
           }
       }


    public void MoveToElement(List<MobileElement> elementList)

    {
        try
        {
            Actions action = new Actions(factory.driver);
            action.moveToElement((WebElement) elementList);
            action.perform();
        }

        catch(Exception ex)
        {
            if(elementList==null)
            {
                MyLogger.log.error("Element is null, Must provide a location for a move action.");
            }

            else
            {
                MyLogger.log.error(ex);

            }
        }
    }


    public MobileElement FindElement(String Key, MobileElement ParentElement)
    {
        MobileElement element= null;
        ParseLocators KeyObject=  ParseLocators.GetValues(Key);
        try
        {
            switch (KeyObject.locator)

            {
                case "Name":
                {
                    element = (MobileElement) ParentElement.findElementByName(KeyObject.value);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    //MoveToElement(element);
                    break;
                }

                case "XPath":
                {
                    element = (MobileElement) ParentElement.findElementByXPath(KeyObject.value);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    //MoveToElement(element);
                    break;
                }
                case "Class":
                {
                    element = (MobileElement) ParentElement.findElementByClassName(KeyObject.value);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    //MoveToElement(element);
                    break;
                }
                case "Id":
                {
                    element = (MobileElement) ParentElement.findElementById(KeyObject.value);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    // MoveToElement(element);
                    break;
                }
                case "LinkText":
                {
                    element = (MobileElement) ParentElement.findElementByLinkText(KeyObject.value);
                    wait.until(ExpectedConditions.visibilityOf(element));
                    //  MoveToElement(element);
                    break;
                }
                default:
                {
                    System.out.println("Element Not Found");

                }

            }
            if(element != null)
            {
                MyLogger.log.info(Key+" Element has found");
            }
        }

        catch (Exception e)
        {
            if(element == null)
            {
                MyLogger.log.error(e);
                MyLogger.log.error("Cannot find an element "+Key+" using "+KeyObject.locator+" Locator strategy");
                return element;
            }
        }
        return element;
    }

    public List<MobileElement> GetElementList(String Key, MobileElement ParentElement){
        List<MobileElement> elementList= null;
        ParseLocators KeyObject=  ParseLocators.GetValues(Key);
        try
        {

            switch (KeyObject.locator)
            {
                case "Name":
                {
                    elementList = (List<MobileElement>) ParentElement.findElementsByName(KeyObject.value);
                    break;
                }

                case "XPath":
                {
                    elementList = (List<MobileElement>) ParentElement.findElementsByXPath(KeyObject.value);
                    break;
                }
                case "Class":
                {
                    elementList = (List<MobileElement>) ParentElement.findElementsByClassName(KeyObject.value);
                    break;
                }
                case "Id":
                {
                    elementList = (List<MobileElement>) ParentElement.findElementsById(KeyObject.value);
                    break;
                }
                default:
                {
                    MyLogger.log.error("Given Locate Searching Strategy i.e. " + KeyObject.locator + "is not defined in the scope");
                }
            }
        }

        catch (Exception e)
        {
            if(elementList == null)
            {
                MyLogger.log.error(e);
                MyLogger.log.error("Cannot find an element "+Key+"");
                return elementList;
            }
        }

        return elementList;

    }
}
