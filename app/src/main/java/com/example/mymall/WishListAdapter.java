package com.example.mymall;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WishListAdapter extends RecyclerView.Adapter<WishListAdapter.ViewHolder> {
    private List<WishListModel> wishListModelList;
    private Boolean wishlist;

    public WishListAdapter(List<WishListModel> wishListModelList, Boolean wishlist) {
        this.wishListModelList = wishListModelList;
        this.wishlist = wishlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wishlist_item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = wishListModelList.get(position).getProductImage();
        String title = wishListModelList.get(position).getProductTitle();
        int freeCoupens = wishListModelList.get(position).getFreeCoupens();
        String rating = wishListModelList.get(position).getRating();
        int totalRating = wishListModelList.get(position).getTotalRatings();
        String productPrice = wishListModelList.get(position).getProductPrice();
        String cuttedPrice = wishListModelList.get(position).getCuttedPrice();
        String paymentMethod = wishListModelList.get(position).getPaymentMethod();

        holder.setData(resource, title, freeCoupens, rating, totalRating, productPrice, cuttedPrice, paymentMethod);

    }

    @Override
    public int getItemCount() {
        return wishListModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupens;
        private ImageView coupenIcon;
        private TextView rating;
        private TextView totalRating;
        private View priceCut;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView paymentMethod;
       private ImageView delateButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);

            freeCoupens = itemView.findViewById(R.id.free_coupen);
            coupenIcon = itemView.findViewById(R.id.free_coupen_icon);
            rating = itemView.findViewById(R.id.tv_product_rating_miniview);
            totalRating= itemView.findViewById(R.id.total_ratings);
            productPrice = itemView.findViewById(R.id.product_price);
            cuttedPrice = itemView.findViewById(R.id.cutted_price);
            priceCut = itemView.findViewById(R.id.price_cut);
            paymentMethod = itemView.findViewById(R.id.payment_method);
            delateButton = itemView.findViewById(R.id.delete_button);
            coupenIcon = itemView.findViewById(R.id.coupen_icon);
        }

        private void setData(int resource, String title, int freeCoupensNO, String averageRate, int totalRatingNo, String price,
                             String cuttedPriceValue, String payMethod){
            productImage.setImageResource(resource); 
            productTitle.setText(title);
            if (freeCoupensNO <=0){
               freeCoupens.setVisibility(View.INVISIBLE);
               coupenIcon.setVisibility(View.INVISIBLE);
/*                if (freeCoupensNO == 1) {
                    freeCoupens.setText("free " + freeCoupens + " coupen");
                }else {
                    freeCoupens.setText("free " +freeCoupens+ " coupens");
                }*/
            }if (freeCoupensNO == 1){
                freeCoupens.setVisibility(View.VISIBLE);
                coupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setText("Free "+freeCoupensNO+" coupen");
            }if (freeCoupensNO > 1){
                freeCoupens.setVisibility(View.VISIBLE);
                coupenIcon.setVisibility(View.VISIBLE);
                freeCoupens.setText("Free "+freeCoupensNO+" coupens");
            }
            rating.setText(averageRate);
            totalRating.setText(totalRatingNo+" (ratings)");
            productPrice.setText(price);
            cuttedPrice.setText(cuttedPriceValue);
            priceCut.setVisibility(View.VISIBLE);
            paymentMethod.setText(payMethod);

            if (wishlist){
                delateButton.setVisibility(View.VISIBLE);
            }else {
                delateButton.setVisibility(View.GONE);
            }

            delateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "Tuch on delete button", Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productDetailsIntent = new Intent(itemView.getContext(), ProductDetailsActivity.class);
                    itemView.getContext().startActivity(productDetailsIntent);
                }
            });
        }
    }
}
