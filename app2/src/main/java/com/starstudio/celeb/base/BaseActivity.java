package com.starstudio.celeb.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 앱티비티가 로드 완료되였는지 표기하는 필더 onWindowFocusChanged 참고
     */
    private boolean loaded = false;

    /**
     * ContentView ResourceID
     *
     * @return
     */
    protected abstract int setContentLayoutResID();

    /**
     * 액티비티 뷰가 완전히 로드되였을때 호출됨 <br>
     * (액티비티가 완전히 로드되였는지는 onWindowsFocused가 호출될때 완료되였다고 판단함 )
     */
    protected abstract void viewLoadFinished();

    /**
     * 뷰초기화  in onCreate
     */
    protected abstract void initViews();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {

        } else {
            //remove state fragments
            savedInstanceState.remove("android.support.fragments");
        }

        if (setContentLayoutResID() != 0) {
            setContentView(setContentLayoutResID());
        }
        initViews();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (hasFocus) {

            if (!loaded) {
                //로드완료
                loaded = true;

                viewLoadFinished();
            }


        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loaded = false;

    }
}
