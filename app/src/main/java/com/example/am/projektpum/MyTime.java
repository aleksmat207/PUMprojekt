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

public class MyTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_time);
        final TextView HH =  findViewById(R.id.HH);
        final TextView MM =  findViewById(R.id.MM);
        Button btnHHdown =  findViewById(R.id.btnHHdown);
        Button btnHHup =  findViewById(R.id.btnHHup);
        Button btnMMdown =  findViewById(R.id.btnMMdown);
        Button btnAdd=findViewById(R.id.btnAdd);
        Button btnMMup =  findViewById(R.id.btnMMup);
          final Calendar currentTime = Calendar.getInstance();
        SimpleDateFormat HHFormat = new SimpleDateFormat("HH");
        SimpleDateFormat MMFormat = new SimpleDateFormat("mm");
        String myHour=HHFormat.format(currentTime.getTime());
        String myMinute=MMFormat.format(currentTime.getTime());
        HH.setText(myHour);
        MM.setText(myMinute);
        btnHHdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

              currentTime.add(Calendar.HOUR_OF_DAY, -1);//24
                DateFormat hrsFormat = new SimpleDateFormat("HH", Locale.getDefault());
                DateFormat minFormat = new SimpleDateFormat("mm", Locale.getDefault());
                String TimeHour = hrsFormat.format(currentTime.getTime());
                String TimeMinut = minFormat.format(currentTime.getTime());
                HH.setText(TimeHour);
                MM.setText(TimeMinut);

            }

        });
        btnHHup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

                currentTime.add(Calendar.HOUR_OF_DAY, +1);//24
                DateFormat hrsFormat = new SimpleDateFormat("HH", Locale.getDefault());
                DateFormat minFormat = new SimpleDateFormat("mm", Locale.getDefault());
                String TimeHour = hrsFormat.format(currentTime.getTime());
                String TimeMinut = minFormat.format(currentTime.getTime());
                HH.setText(TimeHour);
                MM.setText(TimeMinut);
            }

        });

        btnMMdown.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                currentTime.add(Calendar.MINUTE, -1);
                DateFormat hrsFormat = new SimpleDateFormat("HH", Locale.getDefault());
                DateFormat minFormat = new SimpleDateFormat("mm", Locale.getDefault());
                String TimeHour = hrsFormat.format(currentTime.getTime());
                String TimeMinut = minFormat.format(currentTime.getTime());
                HH.setText(TimeHour);
                MM.setText(TimeMinut);
            }

        });
        btnMMup.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                currentTime.add(Calendar.MINUTE, +1);
                DateFormat hrsFormat = new SimpleDateFormat("HH", Locale.getDefault());
                DateFormat minFormat = new SimpleDateFormat("mm", Locale.getDefault());
                String TimeHour = hrsFormat.format(currentTime.getTime());
                String TimeMinut = minFormat.format(currentTime.getTime());
                HH.setText(TimeHour);
                MM.setText(TimeMinut);
            }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent intent = new Intent(MyTime.this, AddEvent.class);
                startActivity(intent);
            }

        });
    }
}
