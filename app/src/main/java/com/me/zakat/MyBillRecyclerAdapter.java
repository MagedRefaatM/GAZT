package com.me.zakat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class MyBillRecyclerAdapter extends RecyclerView.Adapter<MyBillRecyclerAdapter.ViewHolder>{

    private String[] texts;
    private String randomTexts;

    MyBillRecyclerAdapter(String[] texts) {
        this.texts = texts;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView sellDescriptionTv;
        ImageView sellIconsIv;

        ViewHolder(View v){
            super(v);
            sellDescriptionTv = v.findViewById(R.id.description_text_view);
            sellIconsIv = v.findViewById(R.id.icon_image_view);
        }
    }

    @NonNull
    @Override
    public MyBillRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        randomTexts = texts[new Random().nextInt(texts.length)];
        holder.sellDescriptionTv.setText(randomTexts);
        switch (randomTexts){
            case "مدفوعة":
                holder.sellIconsIv.setImageResource(R.drawable.ic_green);
                break;
            case "غير مدفوعة":
                holder.sellIconsIv.setImageResource(R.drawable.ic_red);
                break;
            case "مسددة جزئيا":
                holder.sellIconsIv.setImageResource(R.drawable.ic_grey);
                break;
        }
    }

    @Override
    public int getItemCount(){return 10;}
}