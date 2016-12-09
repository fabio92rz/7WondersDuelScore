package com.example.fabio.a7wondersduelscore;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio on 06/12/2016.
 */

class Tabs {

    Fragment tab;
    Tabs(){}
}

public class Data {

    private String playerOne;
    private String playerTwo;

    private static Data data;

    List<Tabs> tabses = new ArrayList<Tabs>();

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

    public void register(Tabs tab){


    }
}

