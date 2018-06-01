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
import java.util.Locale;

public class MyCalendar extends AppCompatActivity {


    public TextView Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        final TextView DD =  findViewById(R.id.HH);
        final TextView MM =  findViewById(R.id.MM);
        final TextView YYYY =  findViewById(R.id.YYYY);
        Button btnDDdown =  findViewById(R.id.btnHHdown);
        Button btnDDup =  findViewById(R.id.btnHHup);
        Button btnMMdown =  findViewById(R.id.btnMMdown);
        Button btnMMup =  findViewById(R.id.btnMMup);
       Button btnleft =  findViewById(R.id.btnleft);
       Button back=findViewById(R.id.back);
       Button showDay=findViewById(R.id.showDay);
       Button btnAdd= findViewById(R.id.btnAdd);
         Button right =  findViewById(R.id.right);
        final Calendar cal = Calendar.getInstance();
        final DateFormat dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        final DateFormat dateFormatMonth = new SimpleDateFormat("MM", Locale.getDefault());
        DateFormat weekDay = new SimpleDateFormat("E",Locale.getDefault());
        final DateFormat dateFormatYear = new SimpleDateFormat("yyyy", Locale.getDefault());

        String myDay=dateFormat.format(cal.getTime());
        String myMonth=dateFormatMonth.format(cal.getTime());
        String myYear=dateFormatYear.format(cal.getTime());
        DD.setText(myDay);
        MM.setText(myMonth);
        YYYY.setText(myYear);

        // singelton do data managera
        btnDDdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
          //  int newDay=(day-1);
                cal.add(Calendar.DATE, -1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);

            }

        });
        btnDDup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

                cal.add(Calendar.DATE, +1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);
            }

        });

        btnMMdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                cal.add(Calendar.MONTH,-1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);
            }

        });
        btnMMup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                cal.add(Calendar.MONTH, +1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);
            }

        });
        btnleft.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                cal.add(Calendar.YEAR, -1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);
            }

        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                cal.add(Calendar.YEAR, +1);
                String yesterdayAsDay = dateFormat.format(cal.getTime());
                String yesterdayAsMonth = dateFormatMonth.format(cal.getTime());
                String yesterdayAsYear = dateFormatYear.format(cal.getTime());
                DD.setText(yesterdayAsDay);
                MM.setText(yesterdayAsMonth);
                YYYY.setText(yesterdayAsYear);
            }

        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          Intent intent = new Intent(MyCalendar.this, AddEvent.class);
                                          String d = DD.getText().toString();
                                          Bundle bundle = new Bundle();
                                          bundle.putString("item", d);
                                          String m = MM.getText().toString();
                                          bundle.putString("itemMonth", m);
                                          String y= YYYY.getText().toString();
                                          bundle.putString("itemYear", y);
                                          intent.putExtras(bundle);
                                          startActivity(intent);
                                      }
                                  });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(MyCalendar.this, Menu.class);
                startActivity(intent);
            }
        });

    }

}
