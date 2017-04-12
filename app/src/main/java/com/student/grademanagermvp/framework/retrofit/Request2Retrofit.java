package com.student.grademanagermvp.framework.retrofit;

import android.util.Log;

import com.student.grademanagermvp.framework.Correspond;
import com.student.grademanagermvp.framework.gson.HttpJsonAdapter;
import com.student.grademanagermvp.model.request.BasePostReq;
import com.student.grademanagermvp.model.request.BaseRequest;
import com.student.grademanagermvp.model.request.RequestInterface;
import com.student.grademanagermvp.model.response.BaseRes;

import org.json.JSONException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by huangbiao on 2016/10/29.
 */

public class Request2Retrofit {

    private final String TAG = "Request2Retrofit";

    private RequestCallBackProxy requestCallBackProxy;
    private Call<String> call;
    private BaseRequest request;

    private Observable<String> observable;

    public Request2Retrofit(RequestCallBackProxy requestCallBackProxy, BaseRequest request) {
        this.requestCallBackProxy = requestCallBackProxy;
        this.request = request;
    }

    /**
     * 封装网络请求方法 只使用Retrofit2
     */
    public void request() {
        if (request.getRequestType() == 1) {
            call = RetrofitWrapper.getInstance(Correspond.REGULAR_URL).create(RequestInterface.class)
                    .request(request.generUrl());
        } else if (request.getRequestType() == 2) {
            BasePostReq postReq = (BasePostReq) request;
            try {
                call = RetrofitWrapper.getInstance(Correspond.SNS_URL).create(RequestInterface.class)
                        .request(request.generUrl(), postReq.getPostData());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.code() == 200) {//请求成功
                    String str = response.body();
                    try {
                        BaseRes baseRes = HttpJsonAdapter.getInstance().get(str, request.getResClass());
                        requestCallBackProxy.handleSuccessResponse(baseRes);
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage());
                        e.printStackTrace();
                    }
                } else {//400 500错误
                    BaseRes baseRes = new BaseRes();
                    baseRes.setCode("999");
                    baseRes.setInnercode("999");
                    if (response.code() == 404) {
                        baseRes.setWrongmessage("请求数据失败!");
                        requestCallBackProxy.handleFailureResponse(baseRes);
                    } else if (response.code() == 500) {
                        baseRes.setWrongmessage("服务器繁忙，请稍后重试!");
                        requestCallBackProxy.handleFailureResponse(baseRes);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                BaseRes baseRes = new BaseRes();
                baseRes.setCode("999");
                baseRes.setInnercode("999");
                baseRes.setWrongmessage("网络请求错误!");
                requestCallBackProxy.handleFailureResponse(baseRes);
                Log.e("error", "网络请求错误");
            }
        });
    }

    /**
     * 封装网络请求方法 Retrofit2结合Rxjava
     */
    public void requestByRxJava() {
        if (request.getRequestType() == 1) {
            observable = RetrofitWrapper.getInstance(Correspond.REGULAR_URL).create(RequestInterface.class)
                    .requestByRxJava(request.generUrl());
        } else if (request.getRequestType() == 2) {
            BasePostReq postReq = (BasePostReq) request;
            try {
                observable = RetrofitWrapper.getInstance(Correspond.SNS_URL).create(RequestInterface.class)
                        .requestByRxJava(request.generUrl(), postReq.getPostData());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new HttpResultFunc())
                .subscribe(new RetrofitSubscriber<BaseRes>(requestCallBackProxy));
    }

    private class HttpResultFunc implements Func1<String, BaseRes> {


        @Override
        public BaseRes call(String s) {
            BaseRes baseRes = null;
            try {
                baseRes = HttpJsonAdapter.getInstance().get(s, request.getResClass());
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
                e.printStackTrace();
            }
            return baseRes;
        }
    }

}
