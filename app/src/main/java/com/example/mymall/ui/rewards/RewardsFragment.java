package com.example.mymall.ui.rewards;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymall.OrderDetailsActivity;
import com.example.mymall.R;
import com.example.mymall.RewardModel;
import com.example.mymall.RewardsAdapter;

import java.util.ArrayList;
import java.util.List;

public class RewardsFragment extends Fragment {
    private RecyclerView rewardRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_rewards, container, false);

        rewardRecyclerView = root.findViewById(R.id.rewards_RecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rewardRecyclerView.setLayoutManager(linearLayoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));
        rewardModelList.add(new RewardModel("Product title","Date and time","Coupen body frome compani"));

        RewardsAdapter rewardsAdapter = new RewardsAdapter(rewardModelList);
        rewardRecyclerView.setAdapter(rewardsAdapter);
        rewardsAdapter.notifyDataSetChanged();

        return root;
    }
}