package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

public class AddEvent extends AppCompatActivity {
TextView Date, content;
Button btn_add_event_OK,b;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Date=(TextView) findViewById(R.id.Date);
        content=(TextView) findViewById(R.id.content);
        btn_add_event_OK=(Button) findViewById(R.id.btn_add_event_OK);
        b=(Button) findViewById(R.id.b);
        final DataBaseHelper db = new DataBaseHelper(this);



        //String d="15";
        final String m="03";
       // String y="2018";
        //String myConcatedString  = d  + "." +  m + "."  + y;
     //   Date.setText(myConcatedString);
        btn_add_event_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean czysieudalo;

                czysieudalo = db.wstawWydarzenie(Date.getText().toString(),m);
                if (czysieudalo) {
                    Toast.makeText(AddEvent.this, "Dodanie wydarzenia do bazy powiodło się", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(AddEvent.this, "Dodanie wydarzenia do bazy nie powiodło się", Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEvent.this, MyTime.class);
                startActivity(intent);
            }
        });
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEvent.this, Edit.class);
                startActivity(intent);
            }
        });

    }

//        Spinner s = (Spinner) findViewById(R.id.spinnerNotifyTime);
//        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this,
//                R.array.my_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        s.setAdapter(adapter);


    }

