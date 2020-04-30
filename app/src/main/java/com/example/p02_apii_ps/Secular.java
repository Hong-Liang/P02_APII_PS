package com.example.p02_apii_ps;

public class Secular {
    private String name;
    private String date;
    private int image;

    public Secular(String name, String date, int image) {
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImage() {
        return image;
    }
}
