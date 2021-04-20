package com.myapplicationdev.android.p02_sgholidays;

import java.util.ArrayList;
import java.util.HashMap;

// Singleton Pattern to Access Data in Different Activities
public class MyData {

    private HashMap<String, ArrayList<Holiday>> holidayMap;
    private static MyData myData = new MyData();

    private MyData() { }

    public static MyData getMyData() {
        return myData;
    }

    public HashMap<String, ArrayList<Holiday>> getHolidayMap() {
        return holidayMap;
    }

    public void setHolidayMap(HashMap<String, ArrayList<Holiday>> holidayMap) {
        this.holidayMap = holidayMap;
    }

} // end of class
