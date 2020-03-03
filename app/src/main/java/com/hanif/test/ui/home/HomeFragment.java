package com.hanif.test.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hanif.test.R;
import com.hanif.test.adapter.AuctionAdapter;
import com.hanif.test.api.API;
import com.hanif.test.model.Auction;
import com.hanif.test.model.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeFragment extends Fragment {

    public static final String URL = "http://192.168.43.253:8000/api/v1/";
    private List<Auction> auction = new ArrayList<>();
    private RecyclerView recyclerView;
    private AuctionAdapter auctionAdapter;
    ProgressBar progressBar;

    TextView tvTest;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        auctionAdapter = new AuctionAdapter(this.getActivity(), auction);

        progressBar = view.findViewById(R.id.progressbar);

         tvTest = view.findViewById(R.id.tv_test);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(auctionAdapter);
        
        loadStuff();
    }

    private void loadStuff() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API api = retrofit.create(API.class);
        Call<Result> call = api.view();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
//                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                auction = response.body().getResult();
                auctionAdapter = new AuctionAdapter(getActivity(), auction);
                recyclerView.setAdapter(auctionAdapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}