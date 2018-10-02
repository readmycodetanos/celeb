package com.starstudio.celeb.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public class SplashQuickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this,SplashActivity.class);
        startActivity(intent);
         overridePendingTransition(0,0);
            finish();
    }


}
