package com.example.voiture;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

    }

        @Override
    public void onClickCar(Car item) {

    }

    @Override
    public Context getContext() {
        return null;
    }
}
