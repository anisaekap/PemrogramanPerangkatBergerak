package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    Button btnNextTer;
    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        edtText = findViewById(R.id.edt_text)   ;

        btnNextTer = findViewById(R.id.btn_next_terakhir);
        btnNextTer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = edtText.getText().toString();
                startActivity(new Intent(InsertActivity.this, FinishActivity.class).putExtra("Data",data));
            }
        });
    }
}
