package com.example.voiture;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarListAdapter extends BaseAdapter {

    private ListCar mListC;
    private final Context mContext;
    private LayoutInflater mInflater;
    private ClickableActivity activity;

    public CarListAdapter(Context context, ListCar aListC) {
        this.activity = activity;
        mContext = context;
        mListC = aListC;
        mInflater = LayoutInflater.from(context);
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
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adapter_item,parent,false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //on recup les textview du layout
        TextView tvBrand = (TextView) layoutItem.findViewById(R.id.brand);
        TextView tvModel = (TextView) layoutItem.findViewById(R.id.model);
        //TextView tvYear = (TextView) layoutItem.findViewById(R.id.year);
        //TextView tvKm = (TextView) layoutItem.findViewById(R.id.km);
        //TextView tvGearBox = (TextView) layoutItem.findViewById(R.id.gearBox);
        //TextView tvEnergy = (TextView) layoutItem.findViewById(R.id.energy);
        TextView tvPrice = (TextView) layoutItem.findViewById(R.id.price);

        ImageView image = (ImageView) layoutItem.findViewById(R.id.picture);

        //on remplie les valeurs
        tvBrand.setText(mListC.get(position).getBrand());
        tvModel.setText(mListC.get(position).getModel());
        //tvYear.setText(mListC.get(position).getYear());
        //tvKm.setText(mListC.get(position).getKm());
        //tvGearBox.setText(mListC.get(position).getGearBox());
        //tvEnergy.setText(mListC.get(position).getEnergy());
        tvPrice.setText(mListC.get(position).getPrice());

        image.setImageResource(mListC.get(position).getPicture());

        layoutItem.setOnClickListener(v -> activity.onClickCar(mListC.get(position)));

        return layoutItem;

    }


}
