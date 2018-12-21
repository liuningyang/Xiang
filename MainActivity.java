package com.example.xiang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.xiang.base.activity.BaseActivity;
import com.example.xiang.beans.zhihu.DailyListBean;
import com.example.xiang.presenter.ZhihuPresenter;
import com.example.xiang.view.ZhihuView;

import java.util.logging.Logger;

public class MainActivity extends BaseActivity<ZhihuView,ZhihuPresenter<ZhihuView>> implements ZhihuView {


    @Override
    protected void initData() {
        presenter.getDailyListBean();
    }

    @Override
    protected int createLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void show(DailyListBean dailyListBean) {
        Logger.getLogger(dailyListBean.toString());
    }

    @Override
    protected ZhihuPresenter<ZhihuView> createPresenter() {
        return new ZhihuPresenter<>();
    }
}
