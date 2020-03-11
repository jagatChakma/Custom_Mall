package com.example.mymall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RewardsAdapter extends RecyclerView.Adapter<RewardsAdapter.ViewHolder> {
    List<RewardModel> rewardModelList;
    private Boolean useMiniLayout;

    public RewardsAdapter(List<RewardModel> rewardModelList, boolean useMiniLayout) {
        this.rewardModelList = rewardModelList;
        this.useMiniLayout = useMiniLayout;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (useMiniLayout){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mini_rewards_item_layout, parent, false);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rewards_item_layout, parent, false);
        }

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = rewardModelList.get(position).getTitle();
        String expirDate = rewardModelList.get(position).getExpiryDate();
        String body = rewardModelList.get(position).getCoupenBody();

        holder.setData(title, expirDate, body);
    }

    @Override
    public int getItemCount() {
        return rewardModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView coupenTitle;
        private TextView coupenDate;
        private TextView coupenBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            coupenTitle = itemView.findViewById(R.id.coupen_title);
            coupenDate = itemView.findViewById(R.id.coupen_validity);
            coupenBody = itemView.findViewById(R.id.coupen_body);
        }

        private void setData(final String title, final String expirData, final String body){
            coupenTitle.setText(title);
            coupenDate.setText(expirData);
            coupenBody.setText(body);

            if (useMiniLayout){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ProductDetailsActivity.coupenTitle.setText(title);
                        ProductDetailsActivity.coupenExpiryDate.setText(expirData);
                        ProductDetailsActivity.coupenBody.setText(body);

                        ProductDetailsActivity.showDialogRecyclerView();
                    }
                });
            }
        }
    }
}
