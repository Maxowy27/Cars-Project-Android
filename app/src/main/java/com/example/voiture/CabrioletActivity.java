package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class CabrioletActivity extends AppCompatActivity {

    private CarListAdapter adapterC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabriolet);


        //recup liste car suv
        ListCar listC = ListCar.getInstance();
        listC.constructListCabriolet(this);

        //adapter
        adapterC = new CarListAdapter(this,listC);

        ListView listView = findViewById(R.id.carCabriolet_listview);

        listView.setAdapter(adapterC);

        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, NouveauteActivity.class);
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

    //filtrage searchbar
    private void initSearchWidgets(){
        SearchView searchView = findViewById(R.id.search_box);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterC.filterCabriolet(newText);
                adapterC.notifyDataSetChanged();
                return false;
            }
        });
    }
}
