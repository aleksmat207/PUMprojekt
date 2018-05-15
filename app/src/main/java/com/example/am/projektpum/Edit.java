package com.example.am.projektpum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;

public class Edit extends AppCompatActivity {

    @BindView(R.id.editText)
    TextView editText;
    @BindView(R.id.btnOk)
    Button btnOk;
    @OnClick(R.id.btnOk)

    public void click(View view) {

        Intent intent = new Intent(Edit.this, AddEvent.class);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

    }
}
