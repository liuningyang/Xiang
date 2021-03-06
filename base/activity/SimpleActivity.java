package com.example.xiang.base.activity;

import android.app.Activity;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 利用 on 2018/12/21.
 */

public abstract class SimpleActivity extends AppCompatActivity {
    public Activity mActivity;
    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createLayoutId());
        bind = ButterKnife.bind(this);
        mActivity = this;
        viewCreated();
        initData();
    }



    public void viewCreated() {
    }

    //初始化数据
    protected abstract void initData();
    //初始化布局
    protected abstract int createLayoutId();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!= null){
            bind.unbind();
        }
    }
}
