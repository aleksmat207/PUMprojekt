package com.example.am.projektpum;

import android.content.ActivityNotFoundException;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.ContactsContract;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;
import butterknife.BindView;

public class SpeechRecognition extends AppCompatActivity {
Button btnSpeak;
TextView myText;
Button btnClear;
Button back;
Button btnSearch;
Button btnAdd;
    private DataBaseHelper dbhelper ;
    private Cursor ourCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final DataBaseHelper db = new DataBaseHelper(this);

        setContentView(R.layout.activity_speech);
        myText =  this.findViewById(R.id.myText);
        btnSpeak =  this.findViewById(R.id.btnSpeak);
        btnClear =  this.findViewById(R.id.btnClear);
        back =  this.findViewById(R.id.back);
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

                czysieudalo = db.wstawNotatke(myText.getText().toString());
                if (czysieudalo) {
                    Toast.makeText(SpeechRecognition.this, "Dodanie notatki do bazy powiodło się", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(SpeechRecognition.this, "Dodanie notatki do bazy nie powiodło się", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
String Query="SELECT * FROM " + db.database_table_notatki +  " WHERE " + db.database_table_notatki + " LIKE " + myText.getText();

            }
        });
//            public void onClick(View v) {
//

//                selection =  db.OPIS + " LIKE ?";
//                String[] selectionArgs = new String[]{tag + '%'};
//
//                return new CursorLoader(this, articlesLoaderUri, ARTICLES_PROJECTION,
//                        CacheContract.COLUMN_TITLE + " LIKE ?",
//                        new String[] {mFilterTitle + '%'},
//                        null);



//                Cursor contactsContractContacts = resolver.query(
//                        ContactsContract.Contacts.CONTENT_URI, projection,
//                        ContactsContract.Contacts.DISPLAY_NAME + " like ?",
//                        new String[]{"%" + tag + "%"},
//                        ContactsContract.Contacts.DISPLAY_NAME + " ASC");



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
