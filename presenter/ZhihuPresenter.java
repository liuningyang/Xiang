package com.example.xiang.presenter;

import com.example.xiang.base.presenter.IBasePresenter;
import com.example.xiang.beans.zhihu.DailyListBean;
import com.example.xiang.model.ZhihuModule;
import com.example.xiang.view.ZhihuView;

/**
 * Created by 利用 on 2018/12/21.
 */

public class ZhihuPresenter <V extends ZhihuView> extends IBasePresenter<V> implements ZhihuModule.ZHihuCallback {
    private ZhihuModule zhihuModule = new ZhihuModule();

    public void  getDailyListBean(){
        if (mView != null){
            zhihuModule.getDailyListBean(this);
        }
    }
    @Override
    public void setShowProgressbar() {

    }

    @Override
    public void setHideProgressbar() {

    }

    @Override
    public void setError(String error) {
          if (mView != null){
              mView.showError(error);
          }
    }

    @Override
    public void setDailyListBean(DailyListBean data) {
        if (mView != null) {
            mView.show(data);
        }
    }

}
