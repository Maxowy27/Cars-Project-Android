package com.example.voiture;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CarListAdapter extends BaseAdapter {

    private final ListCar mListC;
    private final Context mContext;
    private final LayoutInflater mInflater;


    public CarListAdapter(Context context, ListCar aListC) {
        mContext = context;
        mListC = aListC;
        mInflater = LayoutInflater.from(context);
    }

    public void filterNouveaute(String query) {
        mListC.list.clear();
        ArrayList<Car> filteredCars = new ArrayList<>();
        ArrayList<Car> allCars = mListC.getNouveaute(mContext);
        if (query.isEmpty()) {
            filteredCars.addAll(allCars);
        } else {
            for (Car car : allCars) {
                if (car.getBrand().toLowerCase().contains(query.toLowerCase())) {
                    filteredCars.add(car);
                }
            }
        }
        mListC.list.clear();
        mListC.list.addAll(filteredCars);
        System.out.println(mListC.list);
        notifyDataSetChanged();
    }
    public void filterPickup(String query) {
        mListC.list.clear();
        ArrayList<Car> filteredCars = new ArrayList<>();
        ArrayList<Car> allCars = mListC.getPickup(mContext);
        if (query.isEmpty()) {
            filteredCars.addAll(allCars);
        } else {
            for (Car car : allCars) {
                if (car.getBrand().toLowerCase().contains(query.toLowerCase())) {
                    filteredCars.add(car);
                }
            }
        }
        mListC.list.clear();
        mListC.list.addAll(filteredCars);
        System.out.println(mListC.list);
        notifyDataSetChanged();
    }

    public void filterCabriolet(String query) {
        mListC.list.clear();
        ArrayList<Car> filteredCars = new ArrayList<>();
        ArrayList<Car> allCars = mListC.getCabriolet(mContext);
        if (query.isEmpty()) {
            filteredCars.addAll(allCars);
        } else {
            for (Car car : allCars) {
                if (car.getBrand().toLowerCase().contains(query.toLowerCase())) {
                    filteredCars.add(car);
                }
            }
        }
        mListC.list.clear();
        mListC.list.addAll(filteredCars);
        System.out.println(mListC.list);
        notifyDataSetChanged();
    }

    public void filterSuv(String query) {
        mListC.list.clear();
        ArrayList<Car> filteredCars = new ArrayList<>();
        ArrayList<Car> allCars = mListC.getSuv(mContext);
        if (query.isEmpty()) {
            filteredCars.addAll(allCars);
        } else {
            for (Car car : allCars) {
                if (car.getBrand().toLowerCase().contains(query.toLowerCase())) {
                    filteredCars.add(car);
                }
            }
        }
        mListC.list.clear();
        mListC.list.addAll(filteredCars);
        System.out.println(mListC.list);
        notifyDataSetChanged();
    }

    public void filterAll(String query) {
        mListC.list.clear();
        ArrayList<Car> filteredCars = new ArrayList<>();
        ArrayList<Car> allCars = mListC.getAllCars(mContext);
        if (query.isEmpty()) {
            filteredCars.addAll(allCars);
        } else {
            for (Car car : allCars) {
                if (car.getBrand().toLowerCase().contains(query.toLowerCase())) {
                    filteredCars.add(car);
                }
            }
        }
        mListC.list.clear();
        mListC.list.addAll(filteredCars);
        System.out.println(mListC.list);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        if (convertView == null){
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adapter_item,parent,false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //on recup les textview du layout
        TextView tvBrand = layoutItem.findViewById(R.id.brand);
        TextView tvModel = layoutItem.findViewById(R.id.model);
        TextView tvPrice = layoutItem.findViewById(R.id.price);

        ImageView image = layoutItem.findViewById(R.id.picture);

        //on remplie les valeurs
        tvBrand.setText(mListC.get(position).getBrand());
        tvModel.setText(mListC.get(position).getModel());
        tvPrice.setText(mListC.get(position).getPrice());

        image.setImageResource(mListC.get(position).getPicture());


        image.setOnClickListener(view -> {
            Car car = mListC.get(position);
            Intent intent = new Intent(mContext,CarInfo.class);
            intent.putExtra("car", car);
            mContext.startActivity(intent);
        });

        return layoutItem;
    }

    @Override
    public int getCount() {
        return mListC.size();
    }

    @Override
    public Object getItem(int i) {
        return mListC.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

}
