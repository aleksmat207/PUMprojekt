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

import butterknife.BindView;
import butterknife.OnClick;

public class AddEvent extends AppCompatActivity {

    @BindView(R.id.b)
    Button b;
    @BindView(R.id.btn_add_event_OK)
    Button btn_add_event_OK;
    @BindView(R.id.Date)
    TextView Date;


    @OnClick(R.id.b)

    public void click(View view) {

        Intent intent = new Intent(AddEvent.this, MyTime.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_add_event_OK)

    public void click2(View view) {

        Intent intent = new Intent(AddEvent.this, MyCalendar.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);


//        Spinner s = (Spinner) findViewById(R.id.spinnerNotifyTime);
//        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
//                R.array.my_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        s.setAdapter(adapter);





    }
}
