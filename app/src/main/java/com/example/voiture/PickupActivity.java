package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

public class PickupActivity extends AppCompatActivity {
    private CarListAdapter adapterP;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickup);

        AppCompatActivity activity = this;

        //recup liste car suv
        ListCar listP = ListCar.getInstance();
        listP.constructListPickup(this);

        adapterP = new CarListAdapter(this,listP,null);

        listView = (ListView) findViewById(R.id.carPickup_listview);

        listView.setAdapter(adapterP);

        findViewById(R.id.buttonNouveaute).setOnClickListener(click -> {
            Intent intent = new Intent(this, NouveauteActivity.class);
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

    private void initSearchWidgets(){
        SearchView searchView = findViewById(R.id.search_box);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapterP.filterPickup(newText);
                adapterP.notifyDataSetChanged();
                return false;
            }
        });
    }
}
