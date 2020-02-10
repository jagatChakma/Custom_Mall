package com.example.mymall.ui.cart;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymall.AddressActivity;
import com.example.mymall.CartAdapter;
import com.example.mymall.CartItemModel;
import com.example.mymall.DeliveryActivity;
import com.example.mymall.R;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    private RecyclerView cartItemsRecyclerView;
    private Button continueButton;

//    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        slideshowViewModel =
//                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
//        final TextView textView = root.findViewById(R.id.text_slideshow);
//        slideshowViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        //

        cartItemsRecyclerView = root.findViewById(R.id.cart_items_recyclerView);
        continueButton = root.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",2,"taka50100/=","taka1054426/=",11,60,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",22,"taka53000/=","taka1054426/=",21,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",12,"taka50500/=","taka1054526/=",14,270,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",25,"taka580400/=","taka1053426/=",21,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",32,"taka50400/=","taka1054126/=",18,0,07));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",27,"taka56000/=","taka1054326/=",12,0,0));
        cartItemModelList.add(new CartItemModel(0,R.drawable.mail,"Nokia 1212",27,"taka56000/=","taka1054326/=",12,0,0));

        cartItemModelList.add(new CartItemModel(1,"total 5 item","454545","50","500","45124512 "));

        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delivryIntent = new Intent(getContext(), AddressActivity.class);
                getActivity().startActivity(delivryIntent);
            }
        });

        return root;
    }
}