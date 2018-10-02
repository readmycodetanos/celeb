package com.starstudio.celeb.ui.activity;

import android.content.Intent;

import com.starstudio.celeb.base.BaseActivity;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public class SplashActivity extends BaseActivity {
    @Override
    protected int setContentLayoutResID() {
        return 0;
    }

    @Override
    protected void viewLoadFinished() {

        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
//        overridePendingTransition(R.anim.fa);

    }

    @Override
    protected void initViews() {

    }
}
