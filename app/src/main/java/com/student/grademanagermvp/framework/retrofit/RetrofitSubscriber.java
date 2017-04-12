package com.student.grademanagermvp.framework.retrofit;

import android.util.Log;

import com.student.grademanagermvp.model.response.BaseRes;

import rx.Subscriber;

/**
 * Created by huangbiao on 2016/10/31.
 */

public class RetrofitSubscriber<T> extends Subscriber<T>{

    private RequestCallBackProxy requestCallBackProxy;

    public RetrofitSubscriber(RequestCallBackProxy requestCallBackProxy) {
        this.requestCallBackProxy = requestCallBackProxy;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        BaseRes baseRes = new BaseRes();
        baseRes.setCode("999");
        baseRes.setInnercode("999");
        baseRes.setWrongmessage("网络请求错误!");
        requestCallBackProxy.handleFailureResponse(baseRes);
        Log.e("error", "网络请求错误");
    }

    @Override
    public void onNext(T t) {
        requestCallBackProxy.handleSuccessResponse(t);
    }
}
