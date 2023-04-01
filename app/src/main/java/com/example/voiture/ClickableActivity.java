package com.example.voiture;

import android.content.Context;

import java.util.ConcurrentModificationException;

public interface ClickableActivity {

    void onClickCar(Car item);

    Context getContext();

}
