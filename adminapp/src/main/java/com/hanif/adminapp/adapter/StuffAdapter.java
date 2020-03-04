package com.hanif.adminapp.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.hanif.adminapp.R;
import com.hanif.adminapp.model.Stuff;

import java.util.ArrayList;
import java.util.List;

public class StuffAdapter extends RecyclerView.Adapter<StuffAdapter.StuffViewHolder> {

    private Context context;
    private List<Stuff> stuffs;
    private ArrayList<Stuff> mData = new ArrayList<>();

    public StuffAdapter(Context context, List<Stuff> stuffs) {
        this.context = context;
        this.stuffs = stuffs;
    }

    @NonNull
    @Override
    public StuffViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_stuff_item, parent, false);
        StuffViewHolder holder = new StuffViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StuffViewHolder holder, int position) {
        Stuff stuff = stuffs.get(position);
        holder.tvStuffName.setText(stuff.getNama_barang());
        holder.tvStuffPrice.setText(stuff.getHarga_awal());
    }

    @Override
    public int getItemCount() {
        return stuffs.size();
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

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Stuff stuff = stuffs.get(position);

            Bundle mBundle = new Bundle();
            mBundle.putString(EXTRA_ID, stuff.getIdBarang());
            Log.d("Error: ", "error");
            Navigation.findNavController(view).navigate(R.id.action_dashboardFragment_to_detailStuffFragment, mBundle);

        }
    }
}
