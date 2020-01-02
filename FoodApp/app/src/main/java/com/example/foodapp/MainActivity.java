package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMkn;
    private ArrayList<MakananKhas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() !=null) {
            getSupportActionBar().setTitle("Makanan Khas Indonesia");
        }

        rvMkn = findViewById(R.id.rv_mkn);
        rvMkn.setHasFixedSize(true);

        list.addAll(MakananData.getListData());
        showRecyleList();
    }

    private void showRecyleList() {
        rvMkn.setLayoutManager(new LinearLayoutManager(this));
        CardMknAdapter cardMknAdapter = new CardMknAdapter(this,list);
        rvMkn.setAdapter(cardMknAdapter);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about_menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId()==R.id.abt){
            startActivity(new Intent(MainActivity.this, About.class));
        }
        return true;
    }
}
