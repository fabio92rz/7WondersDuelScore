package com.example.fabio.a7wondersduelscore;

/**
 * Created by fabio on 06/12/2016.
 */

public class Users {

    private String playerOne;
    private String playerTwo;

    public Users(String playerOne, String playerTwo){

        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Users(){

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
}
