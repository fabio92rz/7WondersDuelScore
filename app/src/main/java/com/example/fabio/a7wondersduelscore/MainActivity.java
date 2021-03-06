package com.example.fabio.a7wondersduelscore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fabio on 29/11/2016.
 */

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout_test);
        setTitle("Score Sheet");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Players"));
        tabLayout.addTab(tabLayout.newTab().setText("Civic"));
        tabLayout.addTab(tabLayout.newTab().setText("Science"));
        tabLayout.addTab(tabLayout.newTab().setText("Commerce"));
        tabLayout.addTab(tabLayout.newTab().setText("Guild"));
        tabLayout.addTab(tabLayout.newTab().setText("Wonders"));
        tabLayout.addTab(tabLayout.newTab().setText("Money"));
        tabLayout.addTab(tabLayout.newTab().setText("Military"));
        tabLayout.addTab(tabLayout.newTab().setText("Score"));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        viewPager = (ViewPager) findViewById(R.id.pager);

        Pager tabAdapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(9);
        tabLayout.addOnTabSelectedListener(this);



        viewPager.setCurrentItem(0);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#607D8B"));
        tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#607D8B"));

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        SharedPreferences sharedPreferences = MainActivity.this.getSharedPreferences(configActivity.SHARED_PREF_NAME, 0);

        //Players
        if (tab.getPosition() == 0){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#607D8B"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#607D8B"));
        }

        //Civic
        if (tab.getPosition() == 1){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0288D1"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#0288D1"));

            String prova = sharedPreferences.getString(configActivity.PLAYER_ONE_NAME, "");
            Log.d("Prova nome", "prova" + prova);

            Bundle bundle=new Bundle();
            bundle.putString("playerOne", prova);
            civicActivity fragobj=new civicActivity();
            fragobj.setArguments(bundle);
        }

        //Science
        if (tab.getPosition() == 2){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#4CAF50"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#4CAF50"));
        }

        //Commerce
        if (tab.getPosition() == 3){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFF00"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFF00"));
        }

        //Guild
        if (tab.getPosition() == 4){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#673AB7"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#673AB7"));
        }

        //Wonders
        if (tab.getPosition() == 5){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#9E9E9E"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#9E9E9E"));
        }

        //Money
        if (tab.getPosition() == 6){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#009688"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#009688"));
        }

        //Military
        if (tab.getPosition() == 7){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#F44336"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#F44336"));
        }

        //Score
        if (tab.getPosition() == 8){

            tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#3F51B5"));
            tabLayout.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#3F51B5"));
        }




    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

