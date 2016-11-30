package com.example.fabio.a7wondersduelscore;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by fabio on 29/11/2016.
 */

public class playersActivity extends Fragment implements View.OnClickListener {

    FloatingActionButton addPlayer;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.players_tab, container, false);

        addPlayer = (FloatingActionButton) v.findViewById(R.id.new_player);
        addPlayer.setOnClickListener(this);

        return v;
    }


    @Override
    public void onClick(View v) {

        if (v == addPlayer){

            Intent newPlayer = new Intent(v.getContext(), newPlayerActivity.class);
            v.getContext().startActivity(newPlayer);

        }


    }
}
