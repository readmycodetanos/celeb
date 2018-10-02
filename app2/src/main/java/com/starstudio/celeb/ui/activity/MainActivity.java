package com.starstudio.celeb.ui.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.starstudio.celeb.R;
import com.starstudio.celeb.base.BaseActivity;
import com.starstudio.celeb.ui.adapter.MainPageAdapter;
import com.starstudio.celeb.view.CustomViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vpMain)
    CustomViewPager mViewPager;

    @BindView(R.id.miMain)
    MagicIndicator mIndicator;


    @Override
    protected int setContentLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void viewLoadFinished() {

    }

    @Override
    protected void initViews() {
        ButterKnife.bind(this,this);
        bindPager();
    }




    private void bindPager() {

        mViewPager.setScrollable(false);
        mViewPager.setAdapter(new MainPageAdapter(getSupportFragmentManager()));
        final CommonNavigator commonNavigator =new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int i) {
                CommonPagerTitleView commonPagerTitleView =new CommonPagerTitleView(context);
                View view = LayoutInflater.from(context).inflate(R.layout.item_indicator_main,null);
                commonPagerTitleView.setContentView(view);

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });

        mIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mIndicator,mViewPager);



    }


}
