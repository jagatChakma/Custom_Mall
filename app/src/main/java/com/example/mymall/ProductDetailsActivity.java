package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    private ViewPager productImagesViewPager;
    private TabLayout viewPagerIndecater;

    private static boolean ALREADY_ADDED_TO_WISHLIST = false;
    private FloatingActionButton addToWishListBtn;

    //product_details-layout
    private TabLayout productDetailsTablayout;
    private ViewPager productDetailsViewpager;

    // rating layout
    private LinearLayout rateNowContainer;

    private Button buyNowButton;
    private Button coupenRedeemButton;

    //dialog
    public static TextView coupenTitle, coupenExpiryDate, coupenBody;
    private static RecyclerView coupensRecyclerView;
    private static LinearLayout selectedCoupen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productImagesViewPager = findViewById(R.id.product_images_viewpager);
        viewPagerIndecater = findViewById(R.id.viewpager_indicator);
        addToWishListBtn = findViewById(R.id.add_to_wishlist_btn);

        productDetailsTablayout = findViewById(R.id.product_details_tabLayout);
        productDetailsViewpager = findViewById(R.id.product_details_viewpager);

        buyNowButton = findViewById(R.id.buy_now_button);
        coupenRedeemButton = findViewById(R.id.coupen_redemption_btn);

        List<Integer> productImages = new ArrayList<>();
        productImages.add(R.drawable.mail);
        productImages.add(R.drawable.mail);
        productImages.add(R.drawable.mail);
        productImages.add(R.drawable.mail);
        productImages.add(R.drawable.mail);

        ProductImagesAdapter productImagesAdapter = new ProductImagesAdapter(productImages);
        productImagesViewPager.setAdapter(productImagesAdapter);

        viewPagerIndecater.setupWithViewPager(productImagesViewPager,true);

        addToWishListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ALREADY_ADDED_TO_WISHLIST){
                    ALREADY_ADDED_TO_WISHLIST = false;
                    addToWishListBtn.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }else {
                    ALREADY_ADDED_TO_WISHLIST = true;
                    addToWishListBtn.setSupportImageTintList(getResources().getColorStateList(R.color.colorPrimary));
                }
            }
        });

        productDetailsViewpager.setAdapter(new ProductDetailsAdapter(getSupportFragmentManager(), productDetailsTablayout.getTabCount()));

        productDetailsViewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productDetailsTablayout));
        productDetailsTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productDetailsViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //rating layout
        rateNowContainer = findViewById(R.id.rate_now_container);
        for (int x = 1; x <rateNowContainer.getChildCount(); x++ ){
            final int starPosition = x;
            rateNowContainer.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setRating(starPosition);
                }
            });
        }

        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(ProductDetailsActivity.this, DeliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });

        coupenRedeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog checkCoupenPriceDialog = new Dialog(ProductDetailsActivity.this);
                checkCoupenPriceDialog.setContentView(R.layout.coupen_redeem_dialog);
                checkCoupenPriceDialog.setCancelable(true);
                checkCoupenPriceDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                //
                ImageView toggleRecyclerView = checkCoupenPriceDialog.findViewById(R.id.toggle_recyclerView);
                coupensRecyclerView = checkCoupenPriceDialog.findViewById(R.id.coupens_recyclerView);
                selectedCoupen = checkCoupenPriceDialog.findViewById(R.id.selected_coupen);

                coupenTitle = checkCoupenPriceDialog.findViewById(R.id.coupen_title);
                coupenExpiryDate = checkCoupenPriceDialog.findViewById(R.id.coupen_validity);
                coupenBody = checkCoupenPriceDialog.findViewById(R.id.coupen_body);

                TextView orginalPrice = checkCoupenPriceDialog.findViewById(R.id.original_price);
                TextView discountedPrice = checkCoupenPriceDialog.findViewById(R.id.discounted_price);

                //............
                LinearLayoutManager layoutManager = new LinearLayoutManager(ProductDetailsActivity.this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                coupensRecyclerView.setLayoutManager(layoutManager);

                List<RewardModel> rewardModelList = new ArrayList<>();
                rewardModelList.add(new RewardModel("Product title1","Date and time1","Coupen body frome compani1"));
                rewardModelList.add(new RewardModel("Product title2","Date and time2","Coupen body frome compani2"));
                rewardModelList.add(new RewardModel("Product title3","Date and time3","Coupen body frome compani3"));
                rewardModelList.add(new RewardModel("Product title4","Date and time4","Coupen body frome compani4"));
                rewardModelList.add(new RewardModel("Product title5","Date and time5","Coupen body frome compani5"));
                rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
                rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
                rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));

                RewardsAdapter rewardsAdapter = new RewardsAdapter(rewardModelList, true);
                coupensRecyclerView.setAdapter(rewardsAdapter);
                rewardsAdapter.notifyDataSetChanged();
                //......................

                toggleRecyclerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialogRecyclerView();
                    }
                });

                checkCoupenPriceDialog.show();
            }
        });

    }

    public static void showDialogRecyclerView(){
        if (coupensRecyclerView.getVisibility() == View.GONE){
            coupensRecyclerView.setVisibility(View.VISIBLE);
            selectedCoupen.setVisibility(View.GONE);
        }else {
            coupensRecyclerView.setVisibility(View.GONE);
            selectedCoupen.setVisibility(View.VISIBLE);
        }
    }

    private void setRating(int starPosition) {
        for (int n = 0; n < rateNowContainer.getChildCount(); n++){
            ImageView starBtn = (ImageView)rateNowContainer.getChildAt(n);
            starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#999696")));

            if (n <= starPosition){
                starBtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffff00")));
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_search_icom){
            return true;
        }else if (id == R.id.main_cart_icon){
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
