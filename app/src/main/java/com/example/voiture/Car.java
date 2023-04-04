package com.example.voiture;

import androidx.annotation.NonNull;
import java.io.Serializable;

public class Car implements Serializable {
    private final String brand;
    private final String model;
    private final String year;
    private final String km;
    private final String gearBox;
    private final String energy;
    private final String price;
    private final int picture;

    //constructeur
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

    public int getPicture() {
        return picture;
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


    @NonNull
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", km='" + km + '\'' +
                ", gearBox='" + gearBox + '\'' +
                ", energy='" + energy + '\'' +
                ", price='" + price + '\'' +
                ", picture=" + picture +
                '}';
    }
}
