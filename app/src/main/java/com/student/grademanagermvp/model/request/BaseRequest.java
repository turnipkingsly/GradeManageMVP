package com.student.grademanagermvp.model.request;

import android.util.Log;

import com.student.grademanagermvp.framework.retrofit.Request2Retrofit;
import com.student.grademanagermvp.framework.retrofit.RequestCallBackProxy;
import com.student.grademanagermvp.model.response.BaseRes;

import retrofit2.Call;

/**
 * Created by huangbiao on 2016/10/30.
 */

public abstract class BaseRequest{

    public int requestType = 1; // 1 get 2 post
    private RequestCallBackProxy requestCallBackProxy;
    private Call<String> call;

    public abstract Class<? extends BaseRes> getResClass();

    public abstract String generUrl();

    public void requestRetrofit(RequestCallBackProxy proxy){
        if (proxy != null){
            setRequestCallBackProxy(proxy);
        }else {
            setRequestCallBackProxy(new RequestCallBackProxy() {
                @Override
                public void handleSuccessResponse(Object baseRes) {

                }

                @Override
                public void handleFailureResponse(BaseRes baseRes) {
                    Log.d("BaseRes",baseRes.getWrongmessage());
                }
            });
        }
        Request2Retrofit request2Retrofit = new Request2Retrofit(requestCallBackProxy,this);
        request2Retrofit.request();
    }

    public void requestByRxJava(RequestCallBackProxy proxy){
        if (proxy != null){
            setRequestCallBackProxy(proxy);
        }else {
            setRequestCallBackProxy(new RequestCallBackProxy() {
                @Override
                public void handleSuccessResponse(Object baseRes) {

                }

                @Override
                public void handleFailureResponse(BaseRes baseRes) {
                    Log.d("BaseRes",baseRes.getWrongmessage());
                }
            });
        }
        Request2Retrofit request2Retrofit = new Request2Retrofit(requestCallBackProxy,this);
        request2Retrofit.requestByRxJava();
    }

    public void setRequestCallBackProxy(RequestCallBackProxy requestCallBackProxy) {
        this.requestCallBackProxy = requestCallBackProxy;
    }

    public int getRequestType() {
        return requestType;
    }
}
