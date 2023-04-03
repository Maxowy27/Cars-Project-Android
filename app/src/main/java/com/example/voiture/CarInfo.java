package com.example.voiture;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

        @SuppressLint("WrongViewCast") LinearLayout layoutItem = (LinearLayout) findViewById(R.id.item_layout);

        TextView tvBrand = (TextView) layoutItem.findViewById(R.id.item_brand);
        TextView tvModel = (TextView) layoutItem.findViewById(R.id.item_model);
        TextView tvYear = (TextView) layoutItem.findViewById(R.id.item_year);
        TextView tvKm = (TextView) layoutItem.findViewById(R.id.item_km);
        TextView tvGearBox = (TextView) layoutItem.findViewById(R.id.item_gearBox);
        TextView tvEnergy = (TextView) layoutItem.findViewById(R.id.item_energy);
        TextView tvPrice = (TextView) layoutItem.findViewById(R.id.item_price);

        ImageView image = (ImageView) layoutItem.findViewById(R.id.item_picture);

        //layoutItem.findViewById(R.id.item_picture).setBackground(car.getPicture());


        tvBrand.setText(car.getBrand());
        tvModel.setText(car.getModel());
        tvYear.setText(car.getYear());
        tvKm.setText(car.getKm());
        tvGearBox.setText(car.getGearBox());
        tvEnergy.setText(car.getEnergy());
        tvPrice.setText(car.getPrice());

        image.setImageResource(car.getPicture());


        TextView tvBrand2 = (TextView) layoutItem.findViewById(R.id.brand2);
        TextView tvModel2 = (TextView) layoutItem.findViewById(R.id.model2);
        TextView tvPrice2 = (TextView) layoutItem.findViewById(R.id.price2);
        ImageView image2 = (ImageView) layoutItem.findViewById(R.id.picture2);
    }
}
