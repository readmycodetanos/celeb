package com.starstudio.celeb.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.starstudio.celeb.ui.fragment.HomeFragment;
import com.starstudio.celeb.ui.fragment.MeFragment;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public class MainPageAdapter extends FragmentPagerAdapter {

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i!=4){
            return new HomeFragment();
        }
        return new MeFragment();
    }


    @Override
    public int getCount() {
        return 5;
    }
}
