package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailMakanan extends AppCompatActivity {

    private int food_id;
    ImageView imgDetail;
    TextView tvName, tvDesc;

    private ArrayList<MakananKhas> listMkn = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        food_id = getIntent().getIntExtra("mkn_id", 0);
        tvName = findViewById(R.id.name_detail);
        tvDesc = findViewById(R.id.desc_detail);
        imgDetail = findViewById(R.id.img_detail);

        listMkn.addAll(MakananData.getListData());
        setLayout();
    }

    void setLayout(){
        this.setTitle(listMkn.get(food_id).getName());
        tvName.setText(listMkn.get(food_id).getName());
        tvDesc.setText(listMkn.get(food_id).getDescription());
        Glide.with(this)
                .load(listMkn.get(food_id).getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(imgDetail);
    }
}

