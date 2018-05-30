package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;



public class Menu extends AppCompatActivity {
    @BindView(R.id.btnCalenar)
    Button btnCalenar;
    @BindView(R.id.btnList)
    Button btnList;





    public void click(View view) {

        Intent intent = new Intent(Menu.this, MyCalendar.class);
        startActivity(intent);

    }
    public void click2(View view) {

        Intent intent = new Intent(Menu.this, List_notes.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_menu);





    }
}
