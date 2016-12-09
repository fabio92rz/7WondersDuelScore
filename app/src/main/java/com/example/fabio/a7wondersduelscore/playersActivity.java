package com.example.fabio.a7wondersduelscore;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class playersActivity extends Fragment implements View.OnClickListener, tabsInterested {

    FloatingActionButton addPlayer;
    TextView playerOne;
    TextView playerTwo;
    ImageView playerOneImage;
    ImageView playerTwoImage;
    ImageView modifyPlayerOne;
    ImageView modifyPlayerTwo;
    private boolean playerOnehasText = false;
    private boolean playerTwohasText = false;
    private static final int REQUEST_TEXT = 0;
    private static final int MODIFY_TEXT_1 = 1;
    private static final int MODIFY_TEXT_2 = 2;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.players_tab, container, false);

        addPlayer = (FloatingActionButton) v.findViewById(R.id.new_player);
        addPlayer.setOnClickListener(this);

        playerOne = (TextView) v.findViewById(R.id.player1);
        playerOneImage = (ImageView) v.findViewById(R.id.player1Image);
        modifyPlayerOne = (ImageView) v.findViewById(R.id.modifyPlayer1);
        modifyPlayerOne.setOnClickListener(this);

        playerTwo = (TextView) v.findViewById(R.id.player2);
        playerTwoImage = (ImageView) v.findViewById(R.id.player2Image);
        modifyPlayerTwo = (ImageView) v.findViewById(R.id.modifiyPlayer2);
        modifyPlayerTwo.setOnClickListener(this);

        Data.getCurrent().register(this);
        return v;
    }


    @Override
    public void onClick(View v) {

        if (v == addPlayer) {

            newPlayerActivity newPlayer = new newPlayerActivity();
            FragmentManager fm = getFragmentManager();
            newPlayer.setTargetFragment(playersActivity.this, REQUEST_TEXT);
            newPlayer.show(fm, "newPlayerPopup");

        }

        if (v == modifyPlayerOne) {

            modifynameActivity modify = new modifynameActivity();
            FragmentManager fm = getFragmentManager();
            modify.setTargetFragment(playersActivity.this, MODIFY_TEXT_1);
            modify.show(fm, "modifyPopup");
        }

        if (v == modifyPlayerTwo) {

            modifynameActivity modify = new modifynameActivity();
            FragmentManager fm = getFragmentManager();
            modify.setTargetFragment(playersActivity.this, MODIFY_TEXT_2);
            modify.show(fm, "modifyPopup");
        }


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_TEXT) {
            String text = data.getStringExtra(newPlayerActivity.nameKey);
            if (text.length() > 0 && !playerOne.getText().toString().equals(text) && !playerTwo.getText().toString().equals(text)) {

                if (!playerOnehasText) {

                    playerOne.setText(text);
                    playerOneImage.setVisibility(View.VISIBLE);
                    modifyPlayerOne.setVisibility(View.VISIBLE);
                    playerOnehasText = true;

                    Toast.makeText(getContext(), "Player inserted", Toast.LENGTH_SHORT).show();

                } else if (!playerTwohasText) {

                    playerTwo.setText(text);
                    playerTwoImage.setVisibility(View.VISIBLE);
                    modifyPlayerTwo.setVisibility(View.VISIBLE);
                    playerTwohasText = true;

                    Toast.makeText(getContext(), "Player inserted", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Player already inserted", Toast.LENGTH_LONG).show();
                    playerOnehasText = false;
                    playerTwohasText = false;

                }
            }
        }

        if (requestCode == MODIFY_TEXT_1) {

            String name = data.getStringExtra(modifynameActivity.mKey);
            if (name.length() > 0 && !playerOne.getText().toString().equals(name) && !playerTwo.getText().toString().equals(name)) {

                if (playerOnehasText) {

                    playerOne.setText(name);
                    Toast.makeText(getContext(), "Player 1 modified", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Player already inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if (requestCode == MODIFY_TEXT_2) {

            String name = data.getStringExtra(modifynameActivity.mKey);
            if (name.length() > 0 && !playerOne.getText().toString().equals(name) && !playerTwo.getText().toString().equals(name)) {

                if (playerTwohasText) {

                    playerTwo.setText(name);
                    Toast.makeText(getContext(), "Player 2 modified", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Player already inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }

    @Override
    public void notifyData() {

        Data.getCurrent().setPlayerOne(playerOne.getText().toString());
        Data.getCurrent().setPlayerTwo(playerTwo.getText().toString());

    }
}

