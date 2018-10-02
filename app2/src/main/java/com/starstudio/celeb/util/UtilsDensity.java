package com.starstudio.celeb.util;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Hongsec on 2016-07-21.
 */
public class UtilsDensity {

    private static UtilsDensity utilsDensity;
    public static UtilsDensity getInstance() {

        if (utilsDensity == null) {
            synchronized (UtilsDensity.class) {
                if (utilsDensity == null) {
                    utilsDensity = new UtilsDensity();
                }
                return utilsDensity;
            }

        }
        return utilsDensity;
    }

    //转换dp为px
    public   int dp2px(Context context, int dip) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f * (dip >= 0 ? 1 : -1));
    }

    //转换px为dp
    public  int px2dp(Context context, int px) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f * (px >= 0 ? 1 : -1));
    }

    //转换sp为px
    public  int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    //转换px为sp
    public  int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * 获取屏幕的宽度
     *
     * @param context
     * @return
     */
    public  int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕的高度
     *
     * @param context
     * @return
     */
    public  int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }


    /**
     *   如果软键盘启动与  SHOW_FORCED 模式，则无法关闭。
     * @param activity
     */
    public  synchronized void hideKeyboard(Activity activity) {
        try {
            if (activity != null) {
                InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManager != null) {
                    if (inputManager.isAcceptingText()) {
                        View focusView = activity.getCurrentFocus();

                        if (focusView != null) {
                            IBinder windowToken = focusView.getWindowToken();
                            if (windowToken != null) {
                                inputManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS );
                            }

                        }


                    }
                }
            }
        } catch (Exception e) {
            // Ignore exceptions if any
//            Log.d("temp", e.toString(), e);
        }
    }

    //显示虚拟键盘
    public  void showKeyboard(View v)
    {
        v.requestFocus();
        InputMethodManager imm = ( InputMethodManager ) v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
        imm.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);

    }


    //输入法是否显示着
    public  boolean keyBoard(EditText edittext)
    {
        boolean bool = false;
        InputMethodManager imm = ( InputMethodManager ) edittext.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
        if ( imm.isActive( ) )
        {
            bool = true;
        }
        return bool;

    }



}
