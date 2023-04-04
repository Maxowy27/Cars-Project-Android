package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class AccountActivity extends AppCompatActivity {
    private static ListCar listR = new ListCar();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        findViewById(R.id.return_button).setOnClickListener(click -> {
            Intent intent = new Intent(this, AllActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.down, R.anim.small);
        });

        findViewById(R.id.location).setOnClickListener(click -> {
            Intent intent = new Intent(this, GeoLocalisation.class);
            startActivity(intent);
            overridePendingTransition(R.anim.right, R.anim.small);
        });

        CarListReservation adapterR = new CarListReservation(this, listR);
        ListView listView = findViewById(R.id.listview_acc);
        listView.setAdapter(adapterR);

        Intent intent = getIntent();
        Car car = (Car) intent.getSerializableExtra("car");
        if (car != null) {
            listR.list.add(car);
        }

    }

}
