package com.tech.royal_vee.studentgpacalculator.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tech.royal_vee.studentgpacalculator.Calculator;
import com.tech.royal_vee.studentgpacalculator.ViewHistory;


public class Pager extends  FragmentStatePagerAdapter {

    //integer to count tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        //Returnung the tab selected
        switch (position){
            case 0:
                Calculator calculator = new Calculator();
                return calculator;
            case 1:
                ViewHistory viewHistory = new ViewHistory();
                return viewHistory;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
