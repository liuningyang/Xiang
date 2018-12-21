package com.example.xiang.model;

import com.example.xiang.base.module.HttpFinishCallback;
import com.example.xiang.beans.zhihu.DailyListBean;
import com.example.xiang.http.BaseObserver;
import com.example.xiang.http.ZhihuManager;
import com.example.xiang.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/21.
 */

public class ZhihuModule {

    public  interface ZHihuCallback extends HttpFinishCallback{
        void setDailyListBean(DailyListBean data);
    }
    public void getDailyListBean(final ZHihuCallback zHihuCallback) {
        zHihuCallback.setShowProgressbar();
        ZhihuManager.getMyServer().getDailyList()
                .compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyListBean>(zHihuCallback) {
                    @Override
                    public void onNext(DailyListBean value) {
                        zHihuCallback.setDailyListBean(value);
                    }
                });

    }
}
