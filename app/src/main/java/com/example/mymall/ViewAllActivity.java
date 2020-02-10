package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class ViewAllActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("All product in this catagory");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);
        gridView = findViewById(R.id.gridview);
        int layout_code = getIntent().getIntExtra("layout_code", -1);

        if (layout_code == 0) {
            recyclerView.setVisibility(View.VISIBLE);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

            List<WishListModel> wishListModelList = new ArrayList<>();

            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title1", 1, "5", 110, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title2", 11, "4", 150, "5000", "5100", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title3", 0, "5", 190, "5000", "5600", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title4", 3, "3", 160, "5000", "5900", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title5", 0, "1", 120, "5000", "5040", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));
            wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4", 100, "5000", "5500", "Cash on delivery"));

            WishListAdapter adapter = new WishListAdapter(wishListModelList, false);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } else if (layout_code == 1) {
            gridView.setVisibility(View.VISIBLE);
            List<HorizontalProducScrolltModel> horizontalProducScrolltModeliList = new ArrayList<>();
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));
            horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail, "Samaung A50", "6/, 3GB/, 43GB/,", "Tk:25000"));

            GridProductLayoutAdapter gridProductLayoutAdapter = new GridProductLayoutAdapter(horizontalProducScrolltModeliList);
            gridView.setAdapter(gridProductLayoutAdapter);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
