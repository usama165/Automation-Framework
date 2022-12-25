package com.appium.Main.Interface;

import io.cucumber.datatable.DataTable;

public interface IList {
    public int GetGridIndexValue(String Symbol,String Position, String AccountValue);
    public void ValidatePosition(String ListKey, String Symbol, String AccountValue, DataTable table);
}
