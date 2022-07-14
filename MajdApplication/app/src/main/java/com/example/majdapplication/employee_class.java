package com.example.majdapplication;

public class employee_class {

    private String id;
    private String name;
    private int img;
    private double salary;

    public employee_class(String id, String name, int img, double salary) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
