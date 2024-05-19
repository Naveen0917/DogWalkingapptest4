package com.example.dogwalkingapptest4;

public class DogWalker {
    private String name;
    private String description;
    private int imageResourceId;
    private int payRate; // Pay rate per hour

    public DogWalker(String name, String description, int imageResourceId, int payRate) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getPayRate() {
        return payRate;
    }
}
