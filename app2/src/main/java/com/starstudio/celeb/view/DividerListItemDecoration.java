package com.starstudio.celeb.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by hongsec on 17. 11. 22.
 */

public class DividerListItemDecoration extends RecyclerView.ItemDecoration {


    private boolean enableBottom = true;
    Paint paint = new Paint();


    int dividerHeight = 0;

    public DividerListItemDecoration(Context context, int dividerHeight,int color) {
        this.dividerHeight = dividerHeight;
        paint.setColor(color);
    }

    public DividerListItemDecoration(Context context, int dividerHeight,int color, boolean enableBottom) {
        this.dividerHeight = dividerHeight;
        paint.setColor(color);
        this.enableBottom = enableBottom;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        c.save();
        for (int i = 0; i <= childCount - 1; i++) {
            View view = parent.getChildAt(i);
            float top = view.getBottom();
            float bottom = top + dividerHeight;
            if (i == 0) {
                c.drawRect(left, view.getTop() - dividerHeight, right, view.getTop(), paint);
            }
            if(i==childCount-1 && !enableBottom) {

            }else{
                c.drawRect(left, top, right, bottom, paint);
            }
        }
        c.restore();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);


        outRect.bottom = dividerHeight;
        outRect.top = dividerHeight;
    }
}
