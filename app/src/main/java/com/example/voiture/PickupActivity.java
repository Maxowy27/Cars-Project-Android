package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PickupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        AppCompatActivity activity = this;

        //recup liste car suv
        ListCar listP = ListCar.getInstance();
        listP.constructListPickup(this);

        CarListAdapter adapterP = new CarListAdapter(this,listP,null);

        ListView listView = (ListView) findViewById(R.id.carPickup_listview);

        listView.setAdapter(adapterP);

        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonSuv).setOnClickListener(click -> {
            Intent intent = new Intent(this, SuvActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonCabriolet).setOnClickListener(click -> {
            Intent intent = new Intent(this, CabrioletActivity.class);
            startActivity(intent);
        });

    }
}
