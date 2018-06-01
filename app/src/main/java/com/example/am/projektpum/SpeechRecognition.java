package com.example.am.projektpum;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;

public class SpeechRecognition extends AppCompatActivity {
Button btnSpeak;
TextView myText;
TextView query;
Button btnClear;
Button back;
Button btnSearch;
Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DataBaseHelper db = new DataBaseHelper(this);

        setContentView(R.layout.activity_speech);
        myText =  this.findViewById(R.id.myText);
        btnSpeak =  this.findViewById(R.id.btnSpeak);
        btnClear =  this.findViewById(R.id.btnClear);
        back =  this.findViewById(R.id.back);
        query= this.findViewById(R.id.query);
        btnAdd=this.findViewById(R.id.btnAdd);

btnSearch= this.findViewById(R.id.btnSearch);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpeechRecognition.this, Menu.class);
                startActivity(intent);
            }
        });

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
                try{
                    startActivityForResult(intent,200);
                }catch (ActivityNotFoundException a){
                    Toast.makeText(getApplicationContext(),"Intent problem", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myText.setText("");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean czysieudalo;
                if (myText.getText()!= "") {
                    czysieudalo = db.FunAddNote(myText.getText().toString());
                    if (czysieudalo) {
                        Toast.makeText(SpeechRecognition.this, "Dodanie notatki do bazy powiodło się", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(SpeechRecognition.this, "Dodanie notatki do bazy nie powiodło się", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(SpeechRecognition.this, "W pierwszej kolejności wprowadź tekst", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (myText.getText()!= "")
                {
            String a =myText.getText().toString();
            db.getEvent(a);
            db.getNote(a);
                }
            else {
                    Toast.makeText(SpeechRecognition.this, "W pierwszej kolejności wprowadź tekst", Toast.LENGTH_LONG).show();
                }
            }
        });




    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 200){
            if(resultCode == RESULT_OK && data != null){
                ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
               String wordsResult= result.get(0);


                myText.setText(wordsResult);
            }
        }
    }


}
