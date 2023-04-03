package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class AllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        AppCompatActivity activity = this;

        //recup liste car suv
        ListCar listA = ListCar.getInstance();
        listA.constructListAll(this);


        CarListAdapter adapterA = new CarListAdapter(this,listA,null);


        ListView listView = (ListView) findViewById(R.id.carAll_listview);

        listView.setAdapter(adapterA);


        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonSuv).setOnClickListener(click -> {
            Intent intent = new Intent(this, SuvActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonPickUp).setOnClickListener(click -> {
            Intent intent = new Intent(this, PickupActivity.class);
            startActivity(intent);
        });

    }

}
