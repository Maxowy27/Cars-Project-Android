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

public class CarListReservation extends BaseAdapter {

    private ListCar mListC;
    private final Context mContext;
    private LayoutInflater mInflater;
    private ClickableActivity activity;

    public CarListReservation(Context context, ListCar aListC, ClickableActivity activity) {
        this.activity = activity;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;

        if (convertView == null){
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adapter_item2,parent,false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //on recup les textview du layout
        TextView tvBrand = (TextView) layoutItem.findViewById(R.id.res_brand);
        TextView tvModel = (TextView) layoutItem.findViewById(R.id.res_model);
        //TextView tvYear = (TextView) layoutItem.findViewById(R.id.year);
        //TextView tvKm = (TextView) layoutItem.findViewById(R.id.km);
        //TextView tvGearBox = (TextView) layoutItem.findViewById(R.id.gearBox);
        //TextView tvEnergy = (TextView) layoutItem.findViewById(R.id.energy);
        TextView tvPrice = (TextView) layoutItem.findViewById(R.id.res_price);

        ImageView image = (ImageView) layoutItem.findViewById(R.id.res_picture);

        //on remplie les valeurs
        tvBrand.setText(mListC.get(position).getBrand());
        tvModel.setText(mListC.get(position).getModel());
        //tvYear.setText(mListC.get(position).getYear());
        //tvKm.setText(mListC.get(position).getKm());
        //tvGearBox.setText(mListC.get(position).getGearBox());
        //tvEnergy.setText(mListC.get(position).getEnergy());
        tvPrice.setText(mListC.get(position).getPrice());

        image.setImageResource(mListC.get(position).getPicture());


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car car = mListC.get(position);
                Intent intent = new Intent(mContext,CarInfo.class);
                intent.putExtra("car", car);
                mContext.startActivity(intent);
            }
        });

        //layoutItem.setOnClickListener(v -> activity.onClickCar(mListC.get(position)));


        return layoutItem;

    }
/*
    private ArrayList<CarListAdapter> mListListener = new ArrayList<CarListAdapter>();

    public void addListener(CarListAdapterListener aListener) {
        mListListener.add((CarListAdapter) aListener);
    }

    private void sendListener(Car item, int position){
        MainActivity activity1 = (MainActivity) g
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).ici
        }
    }


    public interface CarListAdapterListener{
        public void onClickCar(Car item, int position);
    }
*/

}

