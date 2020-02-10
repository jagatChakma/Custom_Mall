package com.example.mymall;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductSpecificationFragment extends Fragment {
    private RecyclerView productSpecificationRecyclerView;


    public ProductSpecificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_specification, container, false);

        productSpecificationRecyclerView = view.findViewById(R.id.product_specipication_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        productSpecificationRecyclerView.setLayoutManager(linearLayoutManager);

        List<ProductSpecificationModel> productSpecificationModelList = new ArrayList<>();
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Assus"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"1524"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(0,"Ass"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"jjhfhf","In 46546"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"jjhfhf","In 46546"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"jjhfhf","In 46546"));
        productSpecificationModelList.add(new ProductSpecificationModel(1,"Assus","In Bangladesh"));

        ProductSpecificationAdapter productSpecificationAdapter = new ProductSpecificationAdapter(productSpecificationModelList);
        productSpecificationRecyclerView.setAdapter(productSpecificationAdapter);
        productSpecificationAdapter.notifyDataSetChanged();


        return view;
    }

}
