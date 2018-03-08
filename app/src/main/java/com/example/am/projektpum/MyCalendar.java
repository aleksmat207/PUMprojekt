package com.example.am.projektpum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MyCalendar extends AppCompatActivity {

    Calendar cal = Calendar.getInstance();
    int day=cal.get(Calendar.DAY_OF_MONTH);
    int month=cal.get(Calendar.MONTH);
    int year=cal.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TextView DD = (TextView) findViewById(R.id.DD);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
    }

}
