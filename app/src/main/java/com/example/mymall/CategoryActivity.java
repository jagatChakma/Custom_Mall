package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private RecyclerView categoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("CategoryName");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoryRecyclerView = findViewById(R.id.category_recyclerView);

        ////////////////////// banner slider list
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone, "#F0F0F0"));  // may be have to edit
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E"));

        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E"));

        sliderModelList.add(new SliderModel(R.drawable.common_full_open_on_phone,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.mail,"#333B3E") );
        //////////////////////banner slider list end

        ////////////////////grid product list end
        List<HorizontalProducScrolltModel> horizontalProducScrolltModeliList = new ArrayList<>();
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        horizontalProducScrolltModeliList.add(new HorizontalProducScrolltModel(R.drawable.mail,"Samaung A50","6/, 3GB/, 43GB/,","Tk:25000"));
        ////////////////////grid product list end

        /////////////////////////////////////////////////////////////////////////////////////////Home Action
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(this);
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryRecyclerView.setLayoutManager(testingLayoutManager  );

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Hot Product", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(2,"Related Product as you see", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(2,"Related Product as you see", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(1,R.drawable.mail,"#F0F0F0"));
        homePageModelList.add(new HomePageModel(3,"Most populat sals", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(1,R.drawable.mail,"#F0F0F0"));
        homePageModelList.add(new HomePageModel(2,"Related Product as you see", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(1,R.drawable.mail,"#F0F0F0"));

        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        categoryRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////////////////////////////////////////////////////////////////////////////////////Home Action

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.main_search_icom){
            return true;
        }else if (id == android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
