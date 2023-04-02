package com.example.voiture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatActivity activity = this;

        //recup liste car nouveaute
        ListCar listN = ListCar.getInstance();
        listN.constructListNouveaute(this);

        //recup liste car suv
        //ListCar listS = ListCar.getInstance();
        //listS.constructListSuv(this);

        //recup liste car cabriolet
        //ListCar listC = ListCar.getInstance();
        //listC.constructListCabriolet(this);

        //recup lsite car pick up
        //ListCar listP = ListCar.getInstance();
        //listP.constructListPickup(this);

        //adapters
        CarListAdapter adapterN = new CarListAdapter(this,listN,null);
        //CarListAdapter adapterS = new CarListAdapter(this,listS);
        //CarListAdapter adapterC = new CarListAdapter(this,listC);
        //CarListAdapter adapterP = new CarListAdapter(this,listP);

        ListView listView = (ListView) findViewById(R.id.car_listview);

        listView.setAdapter(adapterN);

        findViewById(R.id.buttonSuv).setOnClickListener(click -> {
            Intent intent = new Intent(this, SuvActivity.class);
            startActivity(intent);
        });

        //adapterN.addListener(this);

    }


    @Override
    public void onClickCar(Car item) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}

