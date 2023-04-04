package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AccountActivity extends AppCompatActivity {
    private ListCar listR = new ListCar();
    private CarListReservation adapterR;
    private ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        findViewById(R.id.return_button).setOnClickListener(click -> {
            Intent intent = new Intent(this, AllActivity.class);
            startActivity(intent);
        });

        adapterR = new CarListReservation(this,listR,null);
        listView = findViewById(R.id.listview_acc);
        listView.setAdapter(adapterR);

        Intent intent = getIntent();
        Car car = (Car) intent.getSerializableExtra("car");
        if (car != null) {
            listR.list.add(car);
        }

    }

}
