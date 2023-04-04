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

public class CarListReservation extends BaseAdapter {

    private final ListCar mListC;
    private final Context mContext;
    private final LayoutInflater mInflater;

    public CarListReservation(Context context, ListCar aListC) {
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
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.adapter_item2,parent,false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //on recup les textview du layout
        TextView tvBrand = layoutItem.findViewById(R.id.res_brand);
        TextView tvModel = layoutItem.findViewById(R.id.res_model);
        TextView tvPrice = layoutItem.findViewById(R.id.res_price);
        ImageView image = layoutItem.findViewById(R.id.res_picture);

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

