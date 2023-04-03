package com.example.voiture;

import android.content.Context;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ListCar {

    ArrayList<Car> list;

    static ListCar Instance = null;

    private ListCar(){
        list = new ArrayList<Car>();
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


    public void constructListAll(Context context){
        try {
            //pour récup un json

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

    public void constructListNouveaute(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetNouveaute(context));
            Toast.makeText(context,"test",Toast.LENGTH_LONG).show();
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                Toast.makeText(context,"length list" + i,Toast.LENGTH_LONG);
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
                Toast.makeText(context,"length list" + list.size(),Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void constructListSuv(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetSuv(context));
            Toast.makeText(context,"test",Toast.LENGTH_LONG).show();
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                Toast.makeText(context,"length list" + i,Toast.LENGTH_LONG);
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
                Toast.makeText(context,"length list" + list.size(),Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void constructListPickup(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetPickup(context));
            Toast.makeText(context,"test",Toast.LENGTH_LONG).show();
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                Toast.makeText(context,"length list" + i,Toast.LENGTH_LONG);
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
                Toast.makeText(context,"length list" + list.size(),Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void constructListCabriolet(Context context){
        list.clear();
        try {
            //pour récup un json

            JSONArray jsonArray = new JSONArray(getJSONFromAssetCabriolet(context));
            Toast.makeText(context,"test",Toast.LENGTH_LONG).show();
            //recup car
            for (int i = 0; i < jsonArray.length(); i++){
                Toast.makeText(context,"length list" + i,Toast.LENGTH_LONG);
                list.add(getCarFromJSONObject(jsonArray.getJSONObject(i),context));
                Toast.makeText(context,"length list" + list.size(),Toast.LENGTH_LONG);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

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
        int picture= context.getResources().getIdentifier(photo, "drawable",  context.getPackageName());


        Car p= new Car(brand,model,year,km,gearBox,energy,price,picture);


        return p;
    }

    //lecture du fichier en string
    private  String getJSONFromAssetNouveaute(Context context) { //static
        String json = null;
        try {
            InputStream is = context.getAssets().open("nouveaute.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }
    private  String getJSONFromAssetSuv(Context context) { //static
        String json = null;
        try {
            InputStream is = context.getAssets().open("suv.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    private  String getJSONFromAssetCabriolet(Context context) { //static
        String json = null;
        try {
            InputStream is = context.getAssets().open("cabriolet.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

    private  String getJSONFromAssetPickup(Context context) { //static
        String json = null;
        try {
            InputStream is = context.getAssets().open("pickup.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;

    }

}
