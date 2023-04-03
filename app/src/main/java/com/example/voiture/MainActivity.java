package com.example.voiture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickableActivity {

    private ListCar listN;
    private CarListAdapter adapterN;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatActivity activity = this;

        //recup liste car nouveaute
        listN = ListCar.getInstance();
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
        adapterN = new CarListAdapter(this,listN,null);
        //CarListAdapter adapterS = new CarListAdapter(this,listS);
        //CarListAdapter adapterC = new CarListAdapter(this,listC);
        //CarListAdapter adapterP = new CarListAdapter(this,listP);

        listView = (ListView) findViewById(R.id.car_listview);

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
                ArrayList<Car> filteredCar = new ArrayList<Car>();
                for(Car car : listN.list){
                    if(car.getBrand().toLowerCase().contains(newText.toLowerCase())){
                        filteredCar.add(car);
                    }
                }
                adapterN = new CarListAdapter(getApplicationContext(),listN,null);
                listView.setAdapter(adapterN);
                return false;
            }
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
