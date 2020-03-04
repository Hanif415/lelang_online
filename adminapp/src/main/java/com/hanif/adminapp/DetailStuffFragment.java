package com.hanif.adminapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hanif.adminapp.adapter.StuffAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailStuffFragment extends Fragment {


    public DetailStuffFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_stuff, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv = view.findViewById(R.id.tv_test);
        String id = getArguments().getString(StuffAdapter.StuffViewHolder.EXTRA_ID);

        tv.setText(id);
    }
}
