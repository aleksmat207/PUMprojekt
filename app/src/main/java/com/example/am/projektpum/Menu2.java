package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class Menu2 extends AppCompatActivity {
    @BindView(R.id.btn_calendar)
    Button btn_calendar;
    @BindView(R.id.btn_shopping)
    Button btn_shopping;
    @BindView(R.id.btn_notes)
    Button btn_notes;
    @OnClick(R.id.btn_calendar)

    public void click(View view) {

        Intent intent = new Intent(Menu2.this, MyCalendar.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_shopping)

    public void click2(View view) {

        Intent intent = new Intent(Menu2.this, MyShoppingList.class);
        startActivity(intent);

    }
    @OnClick(R.id.btn_shopping)

    public void click3(View view) {

        Intent intent = new Intent(Menu2.this, SpeechRecognition.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

    }
}
