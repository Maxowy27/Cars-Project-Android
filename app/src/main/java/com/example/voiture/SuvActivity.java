package com.example.voiture;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class SuvActivity extends AppCompatActivity {

    private CarListAdapter adapterS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suv);

        //recup liste car suv
        ListCar listS = ListCar.getInstance();
        listS.constructListSuv(this);

        //adapter
        adapterS = new CarListAdapter(this,listS);

        ListView listView = findViewById(R.id.carSuv_listview);

        listView.setAdapter(adapterS);

        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, NouveauteActivity.class);
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
            overridePendingTransition(R.anim.top, R.anim.small);
        });

        initSearchWidgets();
    }

    //filtrage searchBar
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
