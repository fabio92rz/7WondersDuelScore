package com.example.fabio.a7wondersduelscore;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by fabio on 29/11/2016.
 */

public class civicActivity extends Fragment {

    private TextView playerOne;
    private TextView playerTwo;
    public ImageView playerOneImage;
    public ImageView playerTwoImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.civic_tab, container, false);

        playerOne = (TextView) v.findViewById(R.id.player1Civic);
        playerOneImage = (ImageView) v.findViewById(R.id.player1CivicImage);

        playerTwo = (TextView) v.findViewById(R.id.player2Civic);
        playerTwoImage = (ImageView) v.findViewById(R.id.player2CivicImage);


        return v;
    }
}
