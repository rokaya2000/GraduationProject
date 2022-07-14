package com.example.itallianoresturant.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itallianoresturant.R;
import com.example.itallianoresturant.modul.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private List<Category> categories;
    private OnRecyclerViewItemClickListener<Category> listener;
    Context context;

    public CategoryAdapter(Context context,List<Category> categories, OnRecyclerViewItemClickListener<Category> listener) {
        this.categories = categories;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,
                null,false);
        CategoryHolder viewHolder = new CategoryHolder(v);

        return viewHolder;

    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        Category c = categories.get(position);
        holder.tittle.setText(c.getCategory_tittle());
        holder.iv.setImageResource (c.getCategory_image ());

        Glide
                .with(context)
                .load(c.getCategory_image ())
                .into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tittle;
        public CategoryHolder(@NonNull final View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.category_item_image_main);
            tittle = itemView.findViewById(R.id.category_item_Name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ONItemClick(getAdapterPosition ());
                }
            });
        }
    }
}
