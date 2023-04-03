package com.example.voiture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SuvActivity extends AppCompatActivity implements ClickableActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suv);

        AppCompatActivity activity = this;

        //recup liste car suv
        ListCar listS = ListCar.getInstance();
        listS.constructListSuv(this);

        CarListAdapter adapterS = new CarListAdapter(this,listS,null);

        ListView listView = (ListView) findViewById(R.id.carSuv_listview);

        listView.setAdapter(adapterS);

        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonCabriolet).setOnClickListener(click -> {
            Intent intent = new Intent(this, CabrioletActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.buttonPickUp).setOnClickListener(click -> {
            Intent intent = new Intent(this, PickupActivity.class);
            startActivity(intent);
        });

    }


        @Override
    public void onClickCar(Car item) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
