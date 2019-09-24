package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.net.URL;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    Button btnMoveActivity;
    Button btnMoveActivityWithData;
    Button btnDial;
    Button btnLink;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = findViewById(R.id.btn_move_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnDial = findViewById(R.id.btn_dial);
        btnDial.setOnClickListener(this);

        btnLink = findViewById(R.id.btn_link);
        btnLink.setOnClickListener(this);

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_move_activity:
                Intent moveActivity = new Intent(MainActivity.this, NewActivity.class);
                startActivity(moveActivity);
                break;

            case R.id.btn_move_data:
                Intent moveActivityWithData = new Intent(MainActivity.this, MoveActivityWithData.class);
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Anisa Eka Pujianti");
                moveActivityWithData.putExtra(MoveActivityWithData.EXTRA_AGE, 19);
                startActivity(moveActivityWithData);
                break;

            case R.id.btn_dial:
                String phoneNumber = "0895386863877";
                Intent dialPhone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhone);
                break;

            case R.id.btn_link:
                Intent Link = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.polines.ac.id/id/"));
                startActivity(Link);
                break;

            case R.id.btn_next:
                Intent insertActivity = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(insertActivity);
        }

    }
}
