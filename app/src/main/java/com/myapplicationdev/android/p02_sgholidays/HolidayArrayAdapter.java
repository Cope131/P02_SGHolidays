package com.myapplicationdev.android.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HolidayArrayAdapter extends ArrayAdapter<Holiday> {

    private final Context context;
    private final ArrayList<Holiday> holidays;

    public HolidayArrayAdapter(@NonNull Context context, int resource, ArrayList<Holiday> holidays) {
        super(context, resource, holidays);
        this.context = context;
        this.holidays = holidays;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View rowView = inflater.inflate(R.layout.holiday_list_item, parent, false);

        // Current Item Object
        Holiday curHoliday = holidays.get(position);

        // Init Item Views
        ImageView holidayIV = rowView.findViewById(R.id.holiday_illustration_image_view);
        TextView holidayName, holidayDate;
        holidayName = rowView.findViewById(R.id.holiday_name_text_view);
        holidayDate = rowView.findViewById(R.id.holiday_date_text_view);

        // Set Data
        holidayIV.setImageDrawable(curHoliday.getImageDrawable());
        holidayName.setText(curHoliday.getName());
        holidayDate.setText(curHoliday.getDate());

        return rowView;
    }

} // end of class
