package com.leonus96.joseph.siscolegio.Adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.leonus96.joseph.siscolegio.Fragments.AsistenciaFragment;
import com.leonus96.joseph.siscolegio.Fragments.CalificacionesFragment;
import com.leonus96.joseph.siscolegio.Fragments.CitacionesFragment;

/**
 * Created by joseph on 28/02/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{
    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new AsistenciaFragment();
            case 1:
                return new CalificacionesFragment();
            case 2:
                return new CitacionesFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
