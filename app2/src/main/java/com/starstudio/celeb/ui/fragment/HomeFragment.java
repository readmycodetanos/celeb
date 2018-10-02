package com.starstudio.celeb.ui.fragment;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.FalsifyFooter;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.starstudio.celeb.R;
import com.starstudio.celeb.base.BaseFragment;
import com.starstudio.celeb.ui.adapter.ContentListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * ================================================
 * Date:2018/10/1
 * Description:
 * ================================================
 */
public class HomeFragment extends BaseFragment {



    @BindView(R.id.srRefresh)
    SmartRefreshLayout mRefreshLayout;

    @BindView(R.id.rvList)
    RecyclerView mRecyclerList;

    ContentListAdapter listAdapter;

    MainSwipeListener mainSwipeListener =new MainSwipeListener();


    @Override
    public void initView() {
        mRecyclerList.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<MultiItemEntity> data = new ArrayList<MultiItemEntity>();
        for(int i=0;i<10;i++){
            data.add(new MultiItemEntity() {
                @Override
                public int getItemType() {
                    return 0;
                }
            });
        }
        listAdapter= new ContentListAdapter(data);
//        mRecyclerList.addItemDecoration(new DividerListItemDecoration(getActivity(),UtilsDensity.getInstance().dp2px(getActivity().getApplicationContext(),12), UtilsVersionMC.getInstance().getColor(getResources(),R.color.colorBg),false));
        mRecyclerList.setAdapter(listAdapter);


        mRefreshLayout.setRefreshHeader(new MaterialHeader(getActivity()));
        mRefreshLayout.setRefreshFooter(new FalsifyFooter(getActivity()));
        mRefreshLayout.setOnRefreshListener(mainSwipeListener);
        mRefreshLayout.setOnRefreshLoadMoreListener(mainSwipeListener);
        mRefreshLayout.autoRefresh();
    }

    @Override
    protected int setContentLayoutResID() {
        return R.layout.fragment_home;
    }




    class MainSwipeListener implements OnRefreshLoadMoreListener{


        @Override
        public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRefreshLayout.finishLoadMore();
                }
            },2000L);
        }

        @Override
        public void onRefresh(@NonNull RefreshLayout refreshLayout) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mRefreshLayout.finishRefresh();
                }
            },2000L);
        }
    }


}
