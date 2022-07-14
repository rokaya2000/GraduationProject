package com.example.itallianoresturant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
private RecyclerView cart_list;
private TextView TotalPrice;
private Button Pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        cart_list=findViewById ( R.id.cart_rv );
        TotalPrice=findViewById ( R.id.tv_cart_total );
        Pay=findViewById ( R.id.cart_btn_pay );
        Pay=findViewById ( R.id.cart_btn_pay );


    }
}
