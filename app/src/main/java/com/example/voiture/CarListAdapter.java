package com.example.voiture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CarListAdapter extends ArrayAdapter<Car> {
    private final Context context;
    private final List<Car> carList;

    public CarListAdapter(Context context, List<Car> carList) {
        super(context, R.layout.list_item_car, carList);
        this.context = context;
        this.carList = carList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.list_item_car, parent, false);
        }

        TextView makeTextView = rowView.findViewById(R.id.make);
        TextView modelTextView = rowView.findViewById(R.id.model);
        TextView yearTextView = rowView.findViewById(R.id.year);

        Car car = carList.get(position);
        makeTextView.setText(car.getMake());
        modelTextView.setText(car.getModel());
        yearTextView.setText(String.valueOf(car.getYear()));

        return rowView;
    }
}
