package com.wonders.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 *
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> fragments;
    private FragmentManager fm;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        this.fm=fm;
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
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
