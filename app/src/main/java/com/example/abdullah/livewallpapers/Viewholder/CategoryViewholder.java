package com.example.abdullah.livewallpapers.Viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abdullah.livewallpapers.Interface.ItemClickListener;
import com.example.abdullah.livewallpapers.R;

public class CategoryViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView category_name;
    public ImageView backgroud_image;

    ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CategoryViewholder(@NonNull View itemView) {
        super(itemView);

        backgroud_image = (ImageView)itemView.findViewById(R.id.image);
        category_name = (TextView) itemView.findViewById(R.id.name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition());

    }
}
