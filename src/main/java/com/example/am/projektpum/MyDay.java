package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.OnClick;

public class MyDay extends AppCompatActivity {
    @BindView(R.id.ArrowBack)
    Button ArrowBack;
    @BindView(R.id.edit)
    Button edit;
    @OnClick(R.id.ArrowBack)

    public void click(View view) {

        Intent intent = new Intent(MyDay.this, MyCalendar.class);
        startActivity(intent);

    }
    public void click2(View view) {

        Intent intent = new Intent(MyDay.this, Note.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_day);


    }
}
