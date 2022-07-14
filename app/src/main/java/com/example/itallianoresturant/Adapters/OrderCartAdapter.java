package com.example.itallianoresturant.Adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itallianoresturant.R;
import com.example.itallianoresturant.modul.OrderCart;

import java.util.ArrayList;

public class OrderCartAdapter extends RecyclerView.Adapter<OrderCartAdapter.CategoryHolder> {
    private ArrayList<OrderCart>orderCarts;

    public OrderCartAdapter(ArrayList<OrderCart> order_items) {
        this.orderCarts = order_items;
    }

    public ArrayList<OrderCart> getOrder_items() {
        return orderCarts;
    }

    public void setOrder_items(ArrayList<OrderCart> order_items) {
        this.orderCarts = order_items;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ordar_cart,
                null,false);
        CategoryHolder viewHolder = new CategoryHolder(v);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {

        OrderCart oc = orderCarts.get(position);

        if (oc.getOrderImage() != null && !oc.getOrderImage().isEmpty())
            holder.orderimage.setImageURI(Uri.parse(oc.getOrderImage ()));
        holder.name.setText(oc.getOrderName ());
        holder.price.setText(""+oc.getPrice());
        holder.count.setText(""+oc.getCount());
        holder.totalprice.setText(""+oc.getPrice());


    }

    @Override
    public int getItemCount() {
        return orderCarts.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView orderimage;
        TextView name, price, count, totalprice;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            orderimage = itemView.findViewById(R.id.cat_image);
            name = itemView.findViewById(R.id.order_cart_name);
            count = itemView.findViewById(R.id.order_cart_count);
            totalprice = itemView.findViewById(R.id.tv_cart_total);

        }

    }
}
