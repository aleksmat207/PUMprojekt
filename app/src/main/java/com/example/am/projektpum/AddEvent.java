package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddEvent extends AppCompatActivity {
TextView Date, content;
Button btn_add_event_OK,b, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Date=findViewById(R.id.Date);
        content= findViewById(R.id.content);
        btn_add_event_OK= findViewById(R.id.btn_add_event_OK);
        b= findViewById(R.id.b);
        back= findViewById(R.id.back);

        final DataBaseHelper db = new DataBaseHelper(this);

        String d,m,y,c;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

                d= extras.getString("item");
                m= extras.getString("itemMonth");
                y= extras.getString("itemYear");
                c=extras.getString("edit");
            //rezygnujemy z treści wydarzen? może same tytuły?
        } else {
            d= (String) savedInstanceState.getSerializable("item");
            m= (String) savedInstanceState.getSerializable("itemMonth");
            y= (String) savedInstanceState.getSerializable("itemYear");
            c= (String) savedInstanceState.getSerializable("edit");
        }

        String myConcatedString  = d  + "." +  m + "."  + y;
       Date.setText(myConcatedString);

        btn_add_event_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean czysieudalo;
if(content.getText()!= ""){
                czysieudalo = db.FunAddEvent(Date.getText().toString(),content.getText().toString());
                if (czysieudalo) {
                    Toast.makeText(AddEvent.this, "Dodanie wydarzenia do bazy powiodło się", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(AddEvent.this, "Dodanie wydarzenia do bazy nie powiodło się", Toast.LENGTH_LONG).show();
                }}
                else{
    Toast.makeText(AddEvent.this, "w pierwszej kolejności wprowadź tekst", Toast.LENGTH_LONG).show();
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEvent.this, MyCalendar.class);
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

