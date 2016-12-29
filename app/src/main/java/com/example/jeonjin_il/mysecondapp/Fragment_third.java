package com.example.jeonjin_il.mysecondapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.google.android.gms.internal.a.R;


public class Fragment_third extends Fragment {

    public Fragment_third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(com.example.jeonjin_il.mysecondapp.R.layout.fragment_fragment_third, container, false);


        // Inflate the layout for this fragment
        return view;
    }


}
