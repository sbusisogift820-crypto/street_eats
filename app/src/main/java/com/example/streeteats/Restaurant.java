package com.example.streeteats;

public class Restaurant {
    private String name;
    private String category;
    private String rating;
    private int imageResId;

    public Restaurant(String name, String category, String rating, int imageResId) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getRating() { return rating; }
    public int getImageResId() { return imageResId; }
}