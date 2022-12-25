package com.appium.Main.DriverClasses;

import com.appium.Main.Factory.factory;
import io.appium.java_client.MobileElement;
import org.json.simple.JSONArray;

import java.util.List;
//Changes are needed in this class
public class AndoridComboBox
{
    public static AndoridComboBox Instance=null;
    public static AndoridComboBox Instance(){
        {
            if(Instance== null)
            {
                Instance = new AndoridComboBox();

            }
            return Instance;
        }
    }
    public void SelectComboValue(String ComboBoxType, String Value){
      //  List<MobileElement> options=factory.driver.findElementsByClassName("\t\n" + "android.view.ViewGroup");

        ElementFinder.Instance().FindElement(ComboBoxType, factory.driver).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    // MobileElement el= (MobileElement) factory.driver.findElementById("com.logiciel.vbate.android.app.qa:id/accountSpinner");
        List<MobileElement> options=  factory.driver.findElementsById("com.logiciel.vbate.android.app.qa:id/accountSpinner");
        System.out.println("Total number of options available in dropdown:"+options.size());
        for(MobileElement e:options){
            System.out.println(e.findElementByClassName("android.widget.TextView\n").getText());
            e.setValue(Value);
        }
//        List<MobileElement> options=factory.driver.findElementsByClassName("\t\n" + "android.view.ViewGroup");
//        System.out.println("Total number of options available in dropdown:"+options.size());
////          options.get(0).click();
//
//        for(MobileElement e:options)
//        {
//        MobileElement el= e.findElementByClassName("android.widget.TextView");
//          String text= el.getText();
//            System.out.println(text);
//            if(text.equals(Value))
//            {
//                el.setValue(Value);
//                break;
//            }
        }
    }



