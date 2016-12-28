package com.example.jeonjin_il.mysecondapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

public class MainActivity extends AppCompatActivity {


    private android.support.v4.app.FragmentTransaction transaction;
    private DBHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DBHelper(this, "WATER.db", null, 1);
        db.init();


        BottomNavigation bottomNavigation = (BottomNavigation) findViewById(R.id.bottom_navigation);
        bottomNavigation.setDefaultItem((byte) 2);

        setDefault();
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {


                switch (itemId) {
                    case R.id.tab_first:

                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers, new Fragment_first());

                        break;
                    case R.id.tab_second:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers, new Fragment_second());
                        break;
                    case R.id.tab_third:
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers, new Fragment_third());
                        break;

                }
                transaction.commit();
            }
        });

    }
    public void setDefault(){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_fragment_containers,new Fragment_first());
        transaction.commit();
    }
}

