package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardMknAdapter extends RecyclerView.Adapter<CardMknAdapter.ListViewHolder> {

    private ArrayList<MakananKhas> listMakananKhas;
    private Context context;

    public CardMknAdapter(Context context, ArrayList<MakananKhas> listMakananKhas){
        this.listMakananKhas = listMakananKhas;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_mkn, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardMknAdapter.ListViewHolder holder, int position) {
        final MakananKhas makananKhas = listMakananKhas.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makananKhas.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);
        holder.tvName.setText(makananKhas.getName());
        holder.tvDesc.setText(makananKhas.getDescription());

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailMkn = new Intent(context, DetailMakanan.class);
                detailMkn.putExtra("mkn_id", makananKhas.getId());
                context.startActivity(detailMkn);
            }
        });
    }

    @Override
    public int getItemCount() { return listMakananKhas.size(); }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_mkn_list);
            tvName = itemView.findViewById(R.id.name_mkn_list);
            tvDesc = itemView.findViewById(R.id.desc_mkn_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
