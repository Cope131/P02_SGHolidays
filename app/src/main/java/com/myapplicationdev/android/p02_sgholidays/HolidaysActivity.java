package com.myapplicationdev.android.p02_sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HolidaysActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private final static String TAG = "HolidayTypeActivity";

    // Data
    MyData myData = MyData.getMyData();

    // Views
    TextView titleTV;
    ListView listView;
    ExtendedFloatingActionButton backFAB;

    // Holiday Array & Adapter
    ArrayList<Holiday> holidays = new ArrayList<>();
    HolidayArrayAdapter holidayArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holidays);

        // Init Views
        titleTV = findViewById(R.id.holiday_type_title_text_view);
        listView = findViewById(R.id.holiday_list_view);
        backFAB = findViewById(R.id.back_to_types_fab);

        listView.setOnItemClickListener(this::onItemClick);
        backFAB.setOnClickListener(this::onClick);

        // Get Intent
        Intent intent = getIntent();
        String holidayType = intent.getStringExtra("Holiday Type");

        if (holidayType != null) {
            titleTV.setText(holidayType);
        }

        // Get Holidays
        if (myData != null) {
            Log.e(TAG, "myData is NOT NULL");
            HashMap<String, ArrayList<Holiday>> holidayMap = myData.getHolidayMap();
            holidays = holidayMap.get(holidayType);
            for (Holiday holiday: holidays) {
                Log.e(TAG, holiday.getName());
            }
        } else {
            Log.e(TAG, "myData is NULL");
        }

        // Init Adapter
        holidayArrayAdapter = new HolidayArrayAdapter(this, R.layout.holiday_list_item, holidays);
        listView.setAdapter(holidayArrayAdapter);

    } // <-- end of onCreate Method -->


    // Floating Action Button is Clicked
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_to_types_fab:
                finish();
                break;
        }
    }

    // Item from List View is Clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String message = holidays.get(position).getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

} // end of class