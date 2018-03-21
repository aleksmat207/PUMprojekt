package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        final Button btnCalendar = (Button) findViewById(R.id.btnCalenar);
        btnCalendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, MyCalendar.class);
                startActivity(intent);
    }
});
        final Button btnShpList = (Button) findViewById(R.id.btnShpList);
        btnShpList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, MyShoppingList.class);
                startActivity(intent);
            }
        });
    }
}
