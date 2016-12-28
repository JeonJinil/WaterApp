package com.example.jeonjin_il.mysecondapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_second extends Fragment {

    public Fragment_second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View myLayout = inflater.inflate(R.layout.fragment_fragment_second,container,false);
        Button button = (Button) myLayout.findViewById(R.id.setting);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),appSetting.class);
//                startActivity(intent);
            }
        });


        // Inflate the layout for this fragment
        return myLayout;
    }


}
