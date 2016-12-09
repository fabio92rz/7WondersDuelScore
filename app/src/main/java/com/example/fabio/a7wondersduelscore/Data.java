package com.example.fabio.a7wondersduelscore;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 06/12/2016.
 */

public class Data {

    private String playerOne;
    private String playerTwo;

    private static Data data;

    List<tabsInterested> tabses = new ArrayList<tabsInterested>();

    private Data(String playerOne, String playerTwo){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    private Data(){}

    public static Data getCurrent(){

        if (data == null){
            data = new Data();
        }
        return data;
    }

    public String getPlayerOne(){

        return playerOne;
    }

    public void setPlayerOne(String playerOne){

        this.playerOne = playerOne;
    }

    public String getPlayerTwo(){

        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo){

        this.playerTwo = playerTwo;
    }

    public void register(tabsInterested tabs){

        tabses.add(tabs);


    }
}

