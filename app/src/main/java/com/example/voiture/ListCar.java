package com.example.voiture;



import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ListCar {

    ArrayList<Car> list;

    static ListCar Instance = null;

    ListCar(){
        list = new ArrayList<>();
    }

    public int size(){
        return list.size();
    }

    public Car get(int pos){
        return list.get(pos);
    }

    public static ListCar getInstance(){
        if (Instance == null){
            Instance = new ListCar();
        }
        return Instance;
    }


    //list toute les car de toutes categories
    public void constructListAll(Context context){
        try {
            //pour récup json

            JSONArray jsonN = new JSONArray(getJSONFromAssetNouveaute(context));
            JSONArray jsonS= new JSONArray(getJSONFromAssetSuv(context));
            JSONArray jsonC = new JSONArray(getJSONFromAssetCabriolet(context));
            JSONArray jsonP = new JSONArray(getJSONFromAssetPickup(context));


            //recup car
            for (int i = 0; i < jsonN.length(); i++)
                list.add(getCarFromJSONObject(jsonN.getJSONObject(i),context));

            for (int i = 0; i < jsonS.length(); i++)
                list.add(getCarFromJSONObject(jsonS.getJSONObject(i),context));

            for (int i = 0; i < jsonC.length(); i++)
                list.add(getCarFromJSONObject(jsonC.getJSONObject(i),context));

            for (int i = 0; i < jsonP.length(); i++)
                list.add(getCarFromJSONObject(jsonP.getJSONObject(i),context));


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

    //list toute les car de categories nouveaute
    public void constructListNouveaute(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetNouveaute(context));
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    //list toute les car de categories Suv
    public void constructListSuv(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetSuv(context));
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    //list toute les car de categories pickup
    public void constructListPickup(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetPickup(context));
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    //list toute les car de categories cabriolet
    public void constructListCabriolet(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetCabriolet(context));
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    //recup info dans json
    private  Car getCarFromJSONObject(JSONObject jsonObject, Context context) throws JSONException { // static

        String brand = jsonObject.getString("brand");
        String model = jsonObject.getString("model");
        String year = jsonObject.getString("year");
        String km = jsonObject.getString("km");
        String gearBox = jsonObject.getString("gearbox");
        String energy = jsonObject.getString("energy");
        String price = jsonObject.getString("price");



        //photo
        String photo = jsonObject.getString("photo");
        @SuppressLint("DiscouragedApi") int picture= context.getResources().getIdentifier(photo, "drawable",  context.getPackageName());


        return new Car(brand,model,year,km,gearBox,energy,price,picture);
    }

    //recup info json nouveaute
    private  String getJSONFromAssetNouveaute(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("nouveaute.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    //recup info json suv
    private  String getJSONFromAssetSuv(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("suv.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    //recup info json cabriolet
    private  String getJSONFromAssetCabriolet(Context context) {
        String json;
        try {
            InputStream is = context.getAssets().open("cabriolet.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    //recup info json pickup
    private  String getJSONFromAssetPickup(Context context) { //static
        String json;
        try {
            InputStream is = context.getAssets().open("pickup.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    //renvoie liste de toutes les car
    public ArrayList<Car> getAllCars(Context context){
        try {
            //pour récup json

            JSONArray jsonN = new JSONArray(getJSONFromAssetNouveaute(context));
            JSONArray jsonS= new JSONArray(getJSONFromAssetSuv(context));
            JSONArray jsonC = new JSONArray(getJSONFromAssetCabriolet(context));
            JSONArray jsonP = new JSONArray(getJSONFromAssetPickup(context));


            //recup car
            for (int i = 0; i < jsonN.length(); i++)
                list.add(getCarFromJSONObject(jsonN.getJSONObject(i),context));

            for (int i = 0; i < jsonS.length(); i++)
                list.add(getCarFromJSONObject(jsonS.getJSONObject(i),context));

            for (int i = 0; i < jsonC.length(); i++)
                list.add(getCarFromJSONObject(jsonC.getJSONObject(i),context));

            for (int i = 0; i < jsonP.length(); i++)
                list.add(getCarFromJSONObject(jsonP.getJSONObject(i),context));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //renvoie liste de toutes les car de nouveaute
    public ArrayList<Car> getNouveaute(Context context){
        try {
            //pour récup un json

            JSONArray jsonN = new JSONArray(getJSONFromAssetNouveaute(context));

            //recup car
            for (int i = 0; i < jsonN.length(); i++)
                list.add(getCarFromJSONObject(jsonN.getJSONObject(i),context));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //renvoie liste de toutes les car de suv
    public ArrayList<Car> getSuv(Context context){
        try {
            //pour récup un json

            JSONArray jsonS= new JSONArray(getJSONFromAssetSuv(context));

            for (int i = 0; i < jsonS.length(); i++)
                list.add(getCarFromJSONObject(jsonS.getJSONObject(i),context));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //renvoie liste de toutes les car de cabriolet
    public ArrayList<Car> getCabriolet(Context context){
        try {
            JSONArray jsonC = new JSONArray(getJSONFromAssetCabriolet(context));

            for (int i = 0; i < jsonC.length(); i++)
                list.add(getCarFromJSONObject(jsonC.getJSONObject(i),context));


        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //renvoie liste de toutes les car de pickup
    public ArrayList<Car> getPickup(Context context){
        try {

            JSONArray jsonP = new JSONArray(getJSONFromAssetPickup(context));

            for (int i = 0; i < jsonP.length(); i++)
                list.add(getCarFromJSONObject(jsonP.getJSONObject(i),context));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @NonNull
    public String toString() {
        return "ListCar{" +
                "list=" + list +
                '}';
    }
}
