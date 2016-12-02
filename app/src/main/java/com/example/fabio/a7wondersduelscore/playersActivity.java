package com.example.fabio.a7wondersduelscore;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
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
    TextView playerTwo;
    ImageView playerOneImage;
    ImageView playerTwoImage;
    ImageView modifyPlayerOne;
    ImageView modifyPlayerTwo;
    private boolean hasText;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.players_tab, container, false);

        addPlayer = (FloatingActionButton) v.findViewById(R.id.new_player);
        addPlayer.setOnClickListener(this);

        playerOne = (TextView) v.findViewById(R.id.player1);
        playerOneImage = (ImageView) v.findViewById(R.id.player1Image);
        modifyPlayerOne = (ImageView) v.findViewById(R.id.modifyPlayer1);

        playerTwo = (TextView) v.findViewById(R.id.player2);
        playerTwoImage = (ImageView) v.findViewById(R.id.player2Image);
        modifyPlayerTwo = (ImageView) v.findViewById(R.id.modifiyPlayer2);


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

        if (requestCode == REQUEST_TEXT) {
            String text = data.getStringExtra(newPlayerActivity.nameKey);
            if (text.length() > 0)
                if (playerOne.getText().toString().equals("")) {

                    playerOne.setText(text);
                    playerOneImage.setVisibility(View.VISIBLE);
                    modifyPlayerOne.setVisibility(View.VISIBLE);
                    hasText = true;

                } else {

                    playerTwo.setText(text);
                    playerTwoImage.setVisibility(View.VISIBLE);
                    modifyPlayerTwo.setVisibility(View.VISIBLE);
                    hasText = true;
                }

        } else {
            playerOne.setText(null);
            playerTwo.setText(null);
            hasText = false;
        }


        }


}

