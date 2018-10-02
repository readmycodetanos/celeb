package com.starstudio.celeb.ui.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.starstudio.celeb.R;

import java.util.List;

public class ContentListAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity,BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ContentListAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(0,R.layout.item_content_timeline);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {


        helper.getView(R.id.clContentLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
