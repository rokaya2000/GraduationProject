package com.example.itallianoresturant.modul;

import java.util.ArrayList;

public class Order {
    private  int id;
    private int user_id;
    private ArrayList<OrderCart>order_items;

    public Order(int id, int user_id, ArrayList<OrderCart> order_items) {
        this.id = id;
        this.user_id = user_id;
        this.order_items = order_items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public ArrayList<OrderCart> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(ArrayList<OrderCart> order_items) {
        this.order_items = order_items;
    }
}
