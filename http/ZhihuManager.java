package com.example.xiang.http;

import com.example.xiang.beans.zhihu.DailyListBean;

import io.reactivex.Observable;

/**
 * Created by 利用 on 2018/12/21.
 */

public class ZhihuManager {
    private static  MyServer myServer;
    public static MyServer getMyServer(){
        if (myServer == null){
            synchronized (MyServer.class){
                if (myServer == null){
                    myServer = HttpManager.getInstance().getServer(MyServer.HOST,MyServer.class);

                }
            }
        }
        return  myServer;
    }

    public Observable<DailyListBean> getDailyList(){
        return myServer.getDailyList();
    }
}
