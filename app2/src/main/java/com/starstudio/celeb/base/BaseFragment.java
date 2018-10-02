package com.starstudio.celeb.base;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public abstract class BaseFragment extends BaseLazyFragmentAbstract {

    protected Unbinder unbinder;

    public abstract void initView();

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(setContentLayoutResID());
        if(unbinder==null){
            unbinder = ButterKnife.bind(this, getContentView());
        }
        initView();
    }

    @Override
    protected void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        try {
            if(unbinder!=null){
                unbinder.unbind();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
