package com.example.voiture;


import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class CarInfo extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        // Récupérer l'objet Car transmis depuis MainActivity
        Car car = (Car) getIntent().getSerializableExtra("car");

        LinearLayout layoutItem = findViewById(R.id.item_layout);

        TextView tvBrand = layoutItem.findViewById(R.id.item_brand);
        TextView tvModel = layoutItem.findViewById(R.id.item_model);
        TextView tvYear = layoutItem.findViewById(R.id.item_year);
        TextView tvKm = layoutItem.findViewById(R.id.item_km);
        TextView tvGearBox = layoutItem.findViewById(R.id.item_gearBox);
        TextView tvEnergy = layoutItem.findViewById(R.id.item_energy);
        TextView tvPrice = layoutItem.findViewById(R.id.item_price);

        ImageView image = layoutItem.findViewById(R.id.item_picture);


        tvBrand.setText(car.getBrand());
        tvModel.setText(car.getModel());
        tvYear.setText(car.getYear());
        tvKm.setText(car.getKm());
        tvGearBox.setText(car.getGearBox());
        tvEnergy.setText(car.getEnergy());
        tvPrice.setText(car.getPrice());

        image.setImageResource(car.getPicture());

        Button addButton = findViewById(R.id.Reserver);
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AccountActivity.class);
            intent.putExtra("car", car);
            startActivity(intent);
        });

        findViewById(R.id.return_button).setOnClickListener(click -> {
            Intent intent = new Intent(this, AllActivity.class);
            startActivity(intent);
        });

    }
}
