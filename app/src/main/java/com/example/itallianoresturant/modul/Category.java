package com.example.itallianoresturant.modul;

public class Category {
    private  int id;
    private  String category_tittle;
    private  int category_image;

    public Category() {
    }

    public Category(int id, String category_tittle, int category_image) {
        this.id = id;
        this.category_tittle = category_tittle;
        this.category_image = category_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_tittle() {
        return category_tittle;
    }

    public void setCategory_tittle(String category_tittle) {
        this.category_tittle = category_tittle;
    }

    public int getCategory_image() {
        return category_image;
    }

    public void setCategory_image(int category_image) {
        this.category_image = category_image;
    }
}
