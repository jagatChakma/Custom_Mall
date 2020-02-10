package com.example.mymall.ui.order;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymall.MyOrderAdapter;
import com.example.mymall.MyOrderItemModel;
import com.example.mymall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {
    private RecyclerView myOrdersRecyclerView;


    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        myOrdersRecyclerView = view.findViewById(R.id.my_orders_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myOrdersRecyclerView.setLayoutManager(layoutManager);

        List<MyOrderItemModel> myOrderItemModelList = new ArrayList<>();
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 2,"Product title", "Product details[skdjf aks dfad fklas dfk asdf]"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 4,"Product title", "Product details[skdjf  sdjflak jsdflkja sdflkj asdf aks dfad fklas dfk asdf]"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 1,"Product title", "Product details[skdjf aks dfad fklas dfk asdf]"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 0,"Product title", "Cancelled"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 2,"Product title", "Product details[skdjf aks dfa sdjkfk;la sdfadf sakldfl;a kjdfd fklas dfk asdf]"));
        myOrderItemModelList.add(new MyOrderItemModel(R.drawable.mail, 3,"Product title", "Cancelled"));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(myOrderItemModelList);
        myOrdersRecyclerView.setAdapter(myOrderAdapter);
        myOrderAdapter.notifyDataSetChanged();

        return view;
    }

}
