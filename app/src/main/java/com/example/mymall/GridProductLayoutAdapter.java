package com.example.mymall;

import android.content.Intent;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class GridProductLayoutAdapter extends BaseAdapter {

    List<HorizontalProducScrolltModel> horizontalProducScrolltModelList;

    public GridProductLayoutAdapter(List<HorizontalProducScrolltModel> horizontalProducScrolltModelList) {
        this.horizontalProducScrolltModelList = horizontalProducScrolltModelList;
    }

    @Override
    public int getCount() {
        return horizontalProducScrolltModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View view;

        if (convertView == null){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrool_item_layout, null);
//            view.setElevation(0);
//            view.setBackground(Color.parseColor("#ffff"));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDeailsIntent = new Intent(parent.getContext(), ProductDetailsActivity.class);
                    parent.getContext().startActivity(productDeailsIntent);
                }
            });

            ImageView productImage = view.findViewById(R.id.h_s_product_image);
            TextView productTitle = view.findViewById(R.id.h_s_product_title);
            TextView productDiscription = view.findViewById(R.id.h_s_product_discription);
            TextView productPrice = view.findViewById(R.id.h_s_product_price);

            productImage.setImageResource(horizontalProducScrolltModelList.get(position).getProductImage());
            productTitle.setText(horizontalProducScrolltModelList.get(position).getProductTitle());
            productDiscription.setText(horizontalProducScrolltModelList.get(position).getProductDiscription());
            productPrice.setText(horizontalProducScrolltModelList.get(position).getProductPrice());
        }else {
            view = convertView;
        }

        return view;
    }
}
