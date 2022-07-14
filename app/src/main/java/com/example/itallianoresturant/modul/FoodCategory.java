package com.example.itallianoresturant.modul;

public class FoodCategory {
    private int id;
    private String title;
    private  String img_url;
    private  String price;
    private  String description;

    public FoodCategory(int id , String title , String img_url , String price , String description) {
        this.id = id;
        this.title = title;
        this.img_url = img_url;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodCategory() {
    }
}
