package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FinishActivity extends AppCompatActivity {
    TextView txtIni;
    String Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        txtIni = findViewById(R.id.txt_ini);

        Hasil = getIntent().getStringExtra("Data");
        txtIni.setText(Hasil);


    }

}
