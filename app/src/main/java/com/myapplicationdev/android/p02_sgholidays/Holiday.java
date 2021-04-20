package com.myapplicationdev.android.p02_sgholidays;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class Holiday {

    private String name;
    private String date;
    private Drawable imageDrawable;
    private String message;

    public Holiday(Context context, String name, String date, int drawableId, String message) {
        this.name = name;
        this.date = date;
        this.imageDrawable = ContextCompat.getDrawable(context, drawableId);
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Drawable getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

} // end of class
