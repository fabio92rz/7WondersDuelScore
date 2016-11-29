package com.example.fabio.a7wondersduelscore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fabio on 29/11/2016.
 */

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                playersActivity playersTab = new playersActivity();
                return playersTab;
            case 1:
                civicActivity civicTab = new civicActivity();
                return civicTab;
            case 2:
                scienceActivity scienceTab = new scienceActivity();
                return scienceTab;
            case 3:
                commerceActivity commerceTab = new commerceActivity();
                return commerceTab;
            case 4:
                guildActivity guildTab = new guildActivity();
                return guildTab;
            case 5:
                wonderActivity wonderTab = new wonderActivity();
                return wonderTab;
            case 6:
                moneyActivity moneyTab = new moneyActivity();
                return moneyTab;
            case 7:
                militaryActivity militaryTab = new militaryActivity();
                return militaryTab;
            case 8:
                ScoreActivity scoreTab = new ScoreActivity();
                return scoreTab;
            default:
                return null;
        }
    }
    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
