package com.example.mymall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {
    private RecyclerView deliveryRecyclerView;
    private Button changeOrAddNewAddressButton;

    public static final int SELECT_ADDRESS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Delivery state");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        deliveryRecyclerView = findViewById(R.id.delivery_recyclerview);
        changeOrAddNewAddressButton = findViewById(R.id.change_or_add_address_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryRecyclerView.setLayoutManager(layoutManager);

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
        deliveryRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        changeOrAddNewAddressButton.setVisibility(View.VISIBLE);
        changeOrAddNewAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAddressesIntent = new Intent(DeliveryActivity.this, MyAddressesActivity.class);
                myAddressesIntent.putExtra("MODE", SELECT_ADDRESS);
                startActivity(myAddressesIntent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
