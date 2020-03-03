package com.hanif.test.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hanif.test.R;
import com.hanif.test.model.Auction;

import java.util.ArrayList;
import java.util.List;

public class AuctionAdapter extends RecyclerView.Adapter<AuctionAdapter.StuffViewHolder> {

    private Context context;
    private List<Auction> auctions;
    private ArrayList<Auction> mData = new ArrayList<>();

    public AuctionAdapter(Context context, List<Auction> auctions) {
        this.context = context;
        this.auctions = auctions;
    }

    @NonNull
    @Override
    public StuffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_auction_item, parent, false);
        StuffViewHolder holder = new StuffViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StuffViewHolder holder, int position) {
        Auction auction = auctions.get(position);
        holder.tvStuffName.setText(auction.getId_barang());
        holder.tvStuffPrice.setText(auction.getHarga_awal());
    }

    @Override
    public int getItemCount() {
        return auctions.size();
    }

    public class StuffViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView stuffImage;
        TextView tvStuffName;
        TextView tvStuffPrice;

        public static final String EXTRA_ID = "extra_name";

        StuffViewHolder(@NonNull View itemView) {
            super(itemView);
            stuffImage = itemView.findViewById(R.id.img);
            tvStuffName = itemView.findViewById(R.id.tv_auction_name);
            tvStuffPrice = itemView.findViewById(R.id.tv_auction_price);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Auction auction = mData.get(position);

            Bundle mBundle = new Bundle();
            mBundle.putString(EXTRA_ID, auction.getId_barang());
            Log.d("Error: ", "error");
            Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_detailAuctionStuffFragment, mBundle);
        }
    }
}
