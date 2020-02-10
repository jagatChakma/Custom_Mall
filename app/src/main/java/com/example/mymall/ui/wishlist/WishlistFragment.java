package com.example.mymall.ui.wishlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymall.R;
import com.example.mymall.WishListAdapter;
import com.example.mymall.WishListModel;

import java.util.ArrayList;
import java.util.List;

public class WishlistFragment extends Fragment {
    private RecyclerView wishListRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_wishlist, container, false);

        wishListRecyclerView = root.findViewById(R.id.my_wishlist_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishListRecyclerView.setLayoutManager(linearLayoutManager);

        List<WishListModel> wishListModelList = new ArrayList<>();

        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title1", 1, "5",110, "5000","5500","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title2", 11, "4",150, "5000","5100","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title3", 0, "5",190, "5000","5600","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title4", 3, "3",160, "5000","5900","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title5", 0, "1",120, "5000","5040","Cash on delivery"));
        wishListModelList.add(new WishListModel(R.drawable.mail, "Product title6", 5, "4",100, "5000","5500","Cash on delivery"));

        WishListAdapter wishListAdapter = new WishListAdapter(wishListModelList,true);
        wishListRecyclerView.setAdapter(wishListAdapter);

        return root;
    }
}