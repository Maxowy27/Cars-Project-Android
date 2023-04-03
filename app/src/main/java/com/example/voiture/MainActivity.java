package com.example.voiture;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.start).setOnClickListener(click -> {
            String value = ((EditText)findViewById(R.id.name)).getText()+"";
            if (value.length() !=0){
                Intent intent = new Intent(this, NouveauteActivity.class);
                intent.putExtra("name",value);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(), "Saisir un nom SVP", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
