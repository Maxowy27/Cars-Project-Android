package com.example.voiture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class NouveauteActivity extends AppCompatActivity {

    private CarListAdapter adapterN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveaute);


        //recup liste car nouveaute
        ListCar listN = ListCar.getInstance();
        listN.constructListNouveaute(this);


        //adapters
        adapterN = new CarListAdapter(this, listN);


        ListView listView = findViewById(R.id.car_listview);

        listView.setAdapter(adapterN);

        findViewById(R.id.buttonSuv).setOnClickListener(click -> {
            Intent intent = new Intent(this, SuvActivity.class);
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

        findViewById(R.id.account_button).setOnClickListener(click -> {
            Intent intent = new Intent(this, AccountActivity.class);
            startActivity(intent);
        });

        initSearchWidgets();
    }

    //filtrage searchBar
    private void initSearchWidgets(){
        SearchView searchView = findViewById(R.id.search_box);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterN.filterNouveaute(newText);
                adapterN.notifyDataSetChanged();
                return false;
            }
        });
    }
}
