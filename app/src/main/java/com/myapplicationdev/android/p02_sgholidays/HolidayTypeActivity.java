package com.myapplicationdev.android.p02_sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HolidayTypeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private final static String TAG = "HolidayTypeActivity";

    // Data
    MyData myData = MyData.getMyData();

    // Views
    ListView listView;

    // Adapter & Array
    ArrayList<String> holidayTypes = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_holiday_types);

        // Init Views
        listView = findViewById(R.id.holiday_types_list_view);

        // Bridging
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, holidayTypes);
        listView.setAdapter(arrayAdapter);

        // List View OnItem Click
        listView.setOnItemClickListener(this::onItemClick);

        // Init Data
        loadHolidays();
        if (myData != null) {
            Log.e(TAG, "myData is NOT NULL");
            HashMap<String, ArrayList<Holiday>> holidayMap = myData.getHolidayMap();
            for (Map.Entry<String, ArrayList<Holiday>> entry : holidayMap.entrySet()) {
                holidayTypes.add(entry.getKey());
                Log.e(TAG, entry.getKey() + " " + entry.getValue().toString());
            }
            arrayAdapter.notifyDataSetChanged();
        } else {
            Log.e(TAG, "myData is NULL");
        }


    } // <-- end of onCreate method -->


    private void loadHolidays() {

        HashMap<String, ArrayList<Holiday>> holidayMap = new HashMap<>();

        // Secular Type Holidays
        ArrayList<Holiday> secularTypeHolidays = new ArrayList<>();
        secularTypeHolidays.add(new Holiday(this, "New Year's Day", "1 January 2021", R.drawable.new_year));
        secularTypeHolidays.add(new Holiday(this, "National Day", "9 August 2021", R.drawable.national_day));
        secularTypeHolidays.add(new Holiday(this, "Labour Day", "1 May 2021", R.drawable.new_year));
        holidayMap.put("Secular", secularTypeHolidays);

        // Ethnic & Religion Holidays
        ArrayList<Holiday> ethnicAndReligionHolidays = new ArrayList<>();
        ethnicAndReligionHolidays.add(new Holiday(this, "Chinese New Year", "1 January 2021", R.drawable.cny));
        ethnicAndReligionHolidays.add(new Holiday(this, "National Day", "12 - 13 February 2021", R.drawable.national_day));
        ethnicAndReligionHolidays.add(new Holiday(this, "Good Friday", "2 April 2021", R.drawable.good_friday));
        ethnicAndReligionHolidays.add(new Holiday(this, "Hari Raya Puasa", "13 May 2021", R.drawable.hari_raya_puasa));
        ethnicAndReligionHolidays.add(new Holiday(this, "Vesak Day", "26 May 2021", R.drawable.vesak_day));
        ethnicAndReligionHolidays.add(new Holiday(this, "Hari Raya Haji", "20 July 2021", R.drawable.hari_raya_haji));
        ethnicAndReligionHolidays.add(new Holiday(this, "Deepavali", "4 November 2021", R.drawable.deepavali));
        ethnicAndReligionHolidays.add(new Holiday(this, "Christmas Day", "25 December 2021", R.drawable.christmas));
        holidayMap.put("Ethnic & Religion", ethnicAndReligionHolidays);

        myData.setHolidayMap(holidayMap);
    }


    // Item is Clicked from List View
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, HolidaysActivity.class);
        String selectedHolidayType = holidayTypes.get(position);
        intent.putExtra("Holiday Type", selectedHolidayType);
        startActivity(intent);

    }

} // end of class