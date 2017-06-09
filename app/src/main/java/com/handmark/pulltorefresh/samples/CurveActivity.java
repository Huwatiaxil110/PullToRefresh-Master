package com.handmark.pulltorefresh.samples;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

/**
 * Created by zc on 2017/6/9.
 */

public class CurveActivity extends Activity{
    PullToRefreshScrollView mScrollView;

    Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            mScrollView.onRefreshComplete();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve);

        initViews();
    }

    private void initViews(){
        mScrollView = (PullToRefreshScrollView) findViewById(R.id.refresh_viw);
        mScrollView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                Log.e("XXXX", "---- onRefresh ----");
                mHandler.sendEmptyMessageDelayed(0x11, 2000);
            }
        });
    }
}





































