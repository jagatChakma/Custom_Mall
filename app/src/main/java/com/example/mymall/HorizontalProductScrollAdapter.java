package com.example.mymall;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {
    private List<HorizontalProducScrolltModel> horizontalProducScrolltModelList;

    public HorizontalProductScrollAdapter(List<HorizontalProducScrolltModel> horizontalProducScrolltModelList) {
        this.horizontalProducScrolltModelList = horizontalProducScrolltModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_scrool_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = horizontalProducScrolltModelList.get(position).getProductImage();
        String title = horizontalProducScrolltModelList.get(position).getProductTitle();
        String discription = horizontalProducScrolltModelList.get(position).getProductDiscription();
        String price = horizontalProducScrolltModelList.get(position).getProductPrice();

        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductDiscription(discription);
        holder.setProductPric(price);
    }

    @Override
    public int getItemCount() {
        if (horizontalProducScrolltModelList.size() > 8){
            return 8;
        }else {
            return horizontalProducScrolltModelList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productTitle, productDiscription, productPric;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDiscription = itemView.findViewById(R.id.h_s_product_discription);
            productPric = itemView.findViewById(R.id.h_s_product_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDeailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDeailsIntent);
                }
            });
        }

        private void setProductImage(int resourse){
            productImage.setImageResource(resourse);
        }
        private void setProductTitle(String title){
            productTitle.setText(title);
        }
        private void setProductDiscription(String discription){
            productDiscription.setText(discription);
        }
        private void setProductPric(String pric){
            productPric.setText(pric);
        }
    }
}
