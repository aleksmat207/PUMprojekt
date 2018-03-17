package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MyCalendar extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

         final TextView DD =  findViewById(R.id.DD);
        final TextView MM =  findViewById(R.id.MM);
       final TextView YYYY =  findViewById(R.id.YYYY);
         Button btnDDdown =  findViewById(R.id.btnDDdown);
     Button btnDDup =  findViewById(R.id.btnDDup);
    Button btnMMdown =  findViewById(R.id.btnMMdown);
      Button btnMMup =  findViewById(R.id.btnMMup);
       Button btnleft =  findViewById(R.id.btnleft);
         Button right =  findViewById(R.id.right);
        final Calendar cal = Calendar.getInstance();
       // DateFormat df1=new SimpleDateFormat("dd");
       // DateFormat df2=new SimpleDateFormat("mm");
       // String myDay=df1.format((new Date()));
       // String myMonth=df2.format((new Date()));
        final int day=cal.get(Calendar.DAY_OF_MONTH);
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
final String myDay=Integer.toString(day);
        String myMonth=Integer.toString(month);
        String myYear=Integer.toString(year);
        DD.setText(myDay);
        MM.setText(myMonth);
        YYYY.setText(myYear);

        btnDDdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
          //  int newDay=(day-1);
                cal.add(Calendar.DATE, -1);
                DateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

            DD.setText(yesterdayAsString);
            }

        });
        btnDDup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //  int newDay=(day-1);
                cal.add(Calendar.DATE, +1);
                DateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

                DD.setText(yesterdayAsString);
            }

        });

        btnMMdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //  int newDay=(day-1);
                cal.add(Calendar.MONTH,-1);
                DateFormat dateFormat = new SimpleDateFormat("MM", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

                MM.setText(yesterdayAsString);
            }

        });
        btnMMup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //  int newDay=(day-1);
                cal.add(Calendar.MONTH, +1);
                DateFormat dateFormat = new SimpleDateFormat("MM", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

                MM.setText(yesterdayAsString);
            }

        });
        btnleft.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //  int newDay=(day-1);
                cal.add(Calendar.YEAR, -1);
                DateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

                YYYY.setText(yesterdayAsString);
            }

        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //  int newDay=(day-1);
                cal.add(Calendar.YEAR, +1);
                DateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.getDefault());
                String yesterdayAsString = dateFormat.format(cal.getTime());

                YYYY.setText(yesterdayAsString);
            }

        });
        final Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MyCalendar.this, Note.class);
                startActivity(intent);
            }
        });
    }

}
