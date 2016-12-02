package com.example.fabio.a7wondersduelscore;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by fabio on 29/11/2016.
 */

public class playersActivity extends Fragment implements View.OnClickListener {

    FloatingActionButton addPlayer;
    private static final int REQUEST_TEXT = 0;
    TextView playerOne;
    ImageView playerOneImage;
    private boolean hasText;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.players_tab, container, false);

        addPlayer = (FloatingActionButton) v.findViewById(R.id.new_player);
        addPlayer.setOnClickListener(this);

        playerOne = (TextView) v.findViewById(R.id.player1);
        playerOneImage = (ImageView) v.findViewById(R.id.player1Image);

        return v;
    }


    @Override
    public void onClick(View v) {

        if (v == addPlayer){

            newPlayerActivity newPlayer = new newPlayerActivity();
            FragmentManager fm = getFragmentManager();
            newPlayer.setTargetFragment(playersActivity.this, REQUEST_TEXT);
            newPlayer.show(fm, "newPlayerPopup");

        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

        if (resultCode != Activity.RESULT_OK)
        {
            return;
        }

        if (requestCode == REQUEST_TEXT)
        {
            String text = data.getStringExtra(newPlayerActivity.nameKey);
            if (text.length() > 0)
            {
                playerOne.setText(text);
                playerOneImage.setVisibility(View.VISIBLE);
                hasText = true;
            }
            else
            {
                playerOne.setText(null);
                hasText = false;
            }
        }


    }
}
