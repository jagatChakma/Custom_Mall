package com.example.mymall.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.mymall.CategoryAdapter;
import com.example.mymall.CategoryModel;
import com.example.mymall.GridProductLayoutAdapter;
import com.example.mymall.HomePageAdapter;
import com.example.mymall.HomePageModel;
import com.example.mymall.HorizontalProducScrolltModel;
import com.example.mymall.HorizontalProductScrollAdapter;
import com.example.mymall.R;
import com.example.mymall.SliderAdapter;
import com.example.mymall.SliderModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

//    private HomeViewModel homeViewModel;

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;
    private List<CategoryModel> categoryModelList;
    private FirebaseFirestore firebaseFirestore;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                ViewModelProviders.of(this).get(HomeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        //////////////////////Home page category section
        categoryRecyclerView = root.findViewById(R.id.home_page_category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        categoryModelList = new ArrayList<CategoryModel>();

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);

        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("CATEGORIES").orderBy("index").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (QueryDocumentSnapshot documentSnapshot : task.getResult()){
                        categoryModelList.add(new CategoryModel(documentSnapshot.get("icon").toString(), documentSnapshot.get("categoryName").toString()));
                    }
                    categoryAdapter.notifyDataSetChanged();
                }else {
                    String error = task.getException().getMessage();
                    Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        ////////////////////// banner slider list
        List<SliderModel> sliderModelList = new ArrayList<SliderModel>();
        sliderModelList.add(new SliderModel(R.drawable.a,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.b,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.c,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.d,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.e,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.f,"#333B3E"));
        sliderModelList.add(new SliderModel(R.drawable.aa,"#F0F0F0"));
        sliderModelList.add(new SliderModel(R.drawable.ab,"#333B3E"));
        //////////////////////banner slider list end

        //////////////////////// HORIZONTAL PRODUCT list
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
        testing = root.findViewById(R.id.home_page_recyclerView);
        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutManager  );

        List<HomePageModel> homePageModelList = new ArrayList<>();
        homePageModelList.add(new HomePageModel(0, sliderModelList));
        homePageModelList.add(new HomePageModel(2,"Hot Product", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(1,R.drawable.mail,"#F0F0F0"));
        homePageModelList.add(new HomePageModel(3,"Most populat sals", horizontalProducScrolltModeliList));
        homePageModelList.add(new HomePageModel(1,R.drawable.mail,"#F0F0F0"));
        homePageModelList.add(new HomePageModel(2,"Related Product as you see", horizontalProducScrolltModeliList));
        HomePageAdapter adapter = new HomePageAdapter(homePageModelList);
        testing.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        /////////////////////////////////////////////////////////////////////////////////////////Home Action

        return root;
    }
}