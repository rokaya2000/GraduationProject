package com.example.itallianoresturant.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itallianoresturant.R;
import com.example.itallianoresturant.modul.AdminItem;

import java.util.ArrayList;
import java.util.List;

public class FoodCategoryAdapter extends RecyclerView.Adapter<FoodCategoryAdapter.CategoryHolder> {
    private List<AdminItem> adminItems;
    private OnRecycleDetailsItemClickListener<AdminItem> listener;
    Context context;

    public FoodCategoryAdapter(List<AdminItem> adminItems , Context context, OnRecycleDetailsItemClickListener<AdminItem> listener) {
        this.adminItems = adminItems;
        this.listener = listener;
        this.context = context;
    }

    public List<AdminItem> getAdminItems() {
        return adminItems;
    }

    public void setFoodCategories(ArrayList<AdminItem> adminItems) {
        this.adminItems = adminItems;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_category_item,
                null,false);
        CategoryHolder viewHolder = new CategoryHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        AdminItem c = adminItems.get(position);

//        if (c.getImg_url() != null && !c.getImg_url().isEmpty())
//            holder.foodiv.setImageURI(Uri.parse(c.getImg_url()));
            holder.tittle.setText(c.getName ());
            holder.price.setText(c.getPrice ());
            holder.description.setText(c.getDescription ());
       // Glide.with(context).load(c.getImg ()).placeholder(R.id.food_item_image);
     /* Glide
                .with(context)
                .load(c.getImg ())
                .into(holder.foodiv);*/
       Glide
                .with(context)
                .load(c.getImg ())
                .into(holder.foodiv);
      //  Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.foodiv);

      //  Picasso.get().load(model.getLink()).fit().centerInside().into(holder.foodiv);

    }

    @Override
    public int getItemCount() {
        return adminItems.size();
    }


    public class CategoryHolder extends RecyclerView.ViewHolder {

        ImageView foodiv;
        TextView tittle, price, description;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);

            foodiv = itemView.findViewById(R.id.food_item_image);
            tittle = itemView.findViewById(R.id.food_item_name);
            price = itemView.findViewById(R.id.food_item_price);
            description = itemView.findViewById(R.id.food_item_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.ONDetalsItem (getAdapterPosition ());
                }
            });


        }
    }
}
