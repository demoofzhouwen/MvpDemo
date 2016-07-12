package com.wonders.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 *
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments=new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(ArrayList<Fragment> fragment){
        fragments.addAll(fragment);
        notifyDataSetChanged();
    }

}
