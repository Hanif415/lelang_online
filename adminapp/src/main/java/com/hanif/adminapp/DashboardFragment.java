package com.hanif.adminapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.hanif.adminapp.adapter.StuffAdapter;
import com.hanif.adminapp.api.LoginAPI;
import com.hanif.adminapp.api.StuffAPI;
import com.hanif.adminapp.model.Result;
import com.hanif.adminapp.model.Stuff;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    public static final String URL = "http://192.168.43.253:8000/api/v1/";
    private List<Stuff> stuffs = new ArrayList<>();
    private RecyclerView recyclerView;
    private StuffAdapter stuffAdapter;
    ProgressBar progressBar;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        stuffAdapter = new StuffAdapter(this.getActivity(), stuffs);

        progressBar = view.findViewById(R.id.progressbar);

        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(stuffAdapter);

        loadStuff();
    }

    private void loadStuff() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StuffAPI api = retrofit.create(StuffAPI.class);

        Call<Result> call = api.view();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
//                String value = response.body().getValue();
                progressBar.setVisibility(View.GONE);

                stuffs = response.body().getResult();
                stuffAdapter = new StuffAdapter(getActivity(), stuffs);
                recyclerView.setAdapter(stuffAdapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
