package com.example.itallianoresturant.modul;

import android.widget.ImageView;
import android.widget.TextView;

public class DetailsItem {
    private int id;
    private String image ;
    private String name;
    private String price;
    private String describtion;
    private String Extra;

    public DetailsItem(int id , ImageView img , TextView name , TextView price , TextView description , TextView extra) {
    }

    public DetailsItem(int id , String image , String name , String price , String describtion , String extra) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.describtion = describtion;
        Extra = extra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getExtra() {
        return Extra;
    }

    public void setExtra(String extra) {
        Extra = extra;
    }
}
