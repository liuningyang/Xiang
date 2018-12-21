package com.example.xiang.base.activity;

import com.example.xiang.base.presenter.BasePresenter;

/**
 * Created by 利用 on 2018/12/21.
 */

public abstract class BaseActivity<V,P extends BasePresenter<V>> extends SimpleActivity {
    public P presenter;

    @Override
    public void viewCreated() {
        super.viewCreated();
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    //创建子类的P层对象
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!= null){
            presenter.detachView();
            presenter = null;
        }
    }
}
