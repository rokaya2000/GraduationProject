package com.example.itallianoresturant.modul;

import android.media.Image;

import java.util.ArrayList;

public class OrderCart {
    private int id;
    private String orderImage;
    private String orderName;
    private String username;
    private String extra;
    private double price;
    private int count;
    private double totalPrice;

    public OrderCart() {
    }

    public OrderCart(int id , String orderImage , String orderName , String username , String extra , double price , int count , double totalPrice) {
        this.id = id;
        this.orderImage = orderImage;
        this.orderName = orderName;
        this.username = username;
        this.extra = extra;
        this.price = price;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}