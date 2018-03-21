package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class Start extends AppCompatActivity {
@BindView(R.id.charIcon)
Button charIcon;
    @BindView(R.id.imageIcon)
    Button imageIcon;

    @OnClick(R.id.charIcon)

    public void click(View view) {

        Intent intent = new Intent(Start.this, Menu2.class);
        startActivity(intent);

    }
    @OnClick  (R.id.imageIcon)

    public void click2(View view) {

        Intent intent = new Intent(Start.this, Menu.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



    }

}
