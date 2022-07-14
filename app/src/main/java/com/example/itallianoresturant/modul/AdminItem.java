package com.example.itallianoresturant.modul;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class AdminItem implements Parcelable {

    String id, categort, name, description, price;
    String img;

    public AdminItem() {
    }

    public AdminItem(String id , String categort , String name , String description , String price , String img) {
        this.id = id;
        this.categort = categort;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategort() {
        return categort;
    }

    public void setCategort(String categort) {
        this.categort = categort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest , int flags) {
        dest.writeString ( this.id );
        dest.writeString ( this.categort );
        dest.writeString ( this.name );
        dest.writeString ( this.description );
        dest.writeString ( this.price );
        dest.writeString ( this.img );
    }

    protected AdminItem(Parcel in) {
        this.id = in.readString ( );
        this.categort = in.readString ( );
        this.name = in.readString ( );
        this.description = in.readString ( );
        this.price = in.readString ( );
        this.img = in.readString ( );
    }

    public static final Parcelable.Creator<AdminItem> CREATOR = new Parcelable.Creator<AdminItem> ( ) {
        @Override
        public AdminItem createFromParcel(Parcel source) {
            return new AdminItem ( source );
        }

        @Override
        public AdminItem[] newArray(int size) {
            return new AdminItem[size];
        }
    };
}
