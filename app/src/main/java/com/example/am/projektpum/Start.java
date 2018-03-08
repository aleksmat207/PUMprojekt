package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final Button charIcon = (Button) findViewById(R.id.charIcon);
        final Button imageIcon = (Button) findViewById(R.id.imageIcon);
        imageIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {

                Intent intent = new Intent(Start.this, Menu.class);
                startActivity(intent);
            }

        });
        charIcon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Start.this, Menu2.class);
                startActivity(intent);
            }

        });
    }

}
