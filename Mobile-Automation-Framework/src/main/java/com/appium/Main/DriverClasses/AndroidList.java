package com.appium.Main.DriverClasses;


import com.appium.Main.Factory.factory;
import com.appium.Main.Interface.IList;
import com.appium.Main.JsonClasses.App;
import com.appium.Main.Logger.MyLogger;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AndroidList implements IList {
    public static AndroidList Instance = null;

    public static AndroidList Instance() {
        {
            if (Instance == null) {
                Instance = new AndroidList();
            }

            return Instance;
        }
    }

    @Override
    public int GetGridIndexValue(String Symbol, String Position, String AccountValue)
    {
        GeneralHelper.Instance().Wait(5000);
        List<MobileElement> List = ElementFinder.Instance().GetElementList("PositionList", factory.driver);
        if (List.size() != 0) {
            MyLogger.log.info("There are " + List.size() + " Positions against " + AccountValue + " account");
        } else {
            MyLogger.log.info("There is no position against " + AccountValue + " account");
            MyLogger.log.error("Cannot find the " + Symbol + "Position as list is empty");
            Assert.fail();
        }
        int index = -1;

        for (MobileElement el : List)
        {
            index++;
            MobileElement Symboltext = ElementFinder.Instance().FindElement("PositionSymbolLabel", el);
            MobileElement Positiontext = ElementFinder.Instance().FindElement("PositionSymbolLabel", el);
            if (Symboltext.getText().equals(Symbol) && Positiontext.getText().equals(Position)) {
                MyLogger.log.info("Index of Position " + Symbol + " against " + AccountValue + " is " + index);
                break;
            } else if (index == List.size() - 1)
            {
                MyLogger.log.error(Position + " Position does not exist of Symbol " + Symbol + " and Account" + AccountValue);
                Assert.fail();
            }
        }
        return index;
    }

    @Override
    public void ValidatePosition(String Symbol, String Position, String AccountValue, DataTable table) {
        int index = GetGridIndexValue(Symbol, Position, AccountValue);
        List<MobileElement> List = ElementFinder.Instance().GetElementList("PositionList", factory.driver);
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            GeneralHelper.Instance().Wait(5000);
            String elementText = ElementFinder.Instance.FindElement(data.get(i).get("Key"), List.get(index)).getText();
            System.out.println(elementText);
            System.out.println(data.get(i).get("Key"));
            if (elementText.equals(data.get(i).get("Value"))) {
                MyLogger.log.info(data.get(i).get("Key") + " Value " + data.get(i).get("Value") + " is validated");
            } else {
                MyLogger.log.error(data.get(i).get("Key") + " Value " + data.get(i).get("Value") + " is not validated");
                org.testng.Assert.fail();
            }
        }
    }


    public void ValidateLocateAtIndex(int index, DataTable table) {
        MobileElement element = ElementFinder.Instance().FindElement("LocateList", factory.driver);
        List<MobileElement> List1 = ElementFinder.Instance().GetElementList("LocateView", element);
        index = (index + 1) + index;
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        for (int i = 0; i < data.size(); i++) {
            GeneralHelper.Instance().Wait(5000);
            String elementText = ElementFinder.Instance.FindElement(data.get(i).get("Key"), List1.get(index)).getText();
            System.out.println(elementText);
            System.out.println(data.get(i).get("Key"));
            if (elementText.equals(data.get(i).get("Value"))) {
                MyLogger.log.info(data.get(i).get("Key") + " Value " + data.get(i).get("Value") + " is validated");
            } else {
                MyLogger.log.error(data.get(i).get("Key") + " Value " + data.get(i).get("Value") + " is not validated");
                org.testng.Assert.fail();
            }
        }
    }

}





