package com.example.voiture;

import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private String model;
    private String year;
    private String km;
    private String gearBox;
    private String energy;
    private String price;
    private int picture;


    public Car(String brand, String model, String year, String km, String gearBox, String energy, String price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.gearBox = gearBox;
        this.energy = energy;
        this.price = price;
    }

    public int getPicture() {
        return picture;
    }

    public Car(String brand, String model, String year, String km, String gearBox, String energy, String price, int picture) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.km = km;
        this.gearBox = gearBox;
        this.energy = energy;
        this.price = price;
        this.picture = picture;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getKm() {
        return km;
    }

    public String getGearBox() {
        return gearBox;
    }

    public String getEnergy() {
        return energy;
    }

    public String getPrice() {
        return price;
    }
}
