package com.example.voiture;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;

public class SuvActivity extends AppCompatActivity implements ClickableActivity{

    private CarListAdapter adapterS;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suv);

        AppCompatActivity activity = this;

        //recup liste car suv
        ListCar listS = ListCar.getInstance();
        listS.constructListSuv(this);

        adapterS = new CarListAdapter(this,listS,null);

        listView = (ListView) findViewById(R.id.carSuv_listview);

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

        findViewById(R.id.buttonAll).setOnClickListener(click -> {
            Intent intent = new Intent(this, AllActivity.class);
            startActivity(intent);
        });
        initSearchWidgets();
    }


    @Override
    public void onClickCar(Car item) {

    }

    @Override
    public Context getContext() {
        return null;
    }

    private void initSearchWidgets() {
        androidx.appcompat.widget.SearchView searchView = findViewById(R.id.search_box);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterS.filterSuv(newText);
                adapterS.notifyDataSetChanged();
                return false;
            }
        });
    }
}
