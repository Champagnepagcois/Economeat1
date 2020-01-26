package com.marlon.economeat1.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.marlon.economeat1.Into;
import com.marlon.economeat1.R;
import com.marlon.economeat1.Search;

public class CenterFragment extends Fragment {
    EditText editText;
    ImageView imageView;
    RecyclerView recyclerView;


    public CenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_center,container, false);


        editText = (EditText) view.findViewById(R.id.id_Et_Search);
        imageView = (ImageView) view.findViewById(R.id.id_Iv_Search);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSearch();
            }
        });
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSearch();
            }
        });



    return view;
    }

    private void OpenSearch() {
        Intent search = new Intent(getContext(), Search.class);
        startActivity(search);
    }


}
