package com.example.voiture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Camry", 2020));
        carList.add(new Car("Honda", "Civic", 2019));
        carList.add(new Car("Ford", "Mustang", 2021));

    }
}