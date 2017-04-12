package com.student.grademanagermvp.model.request;

import com.student.grademanagermvp.model.response.BaseRes;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by huangbiao on 2016/10/29.
 */

public interface RequestInterface{


    @GET("read/fee/getPkgOrdered/3")
    Observable<BaseRes> requestByRxJava(@Query("productid") String productid,
                                         @Query("userindex") String userindex);

    //只是用Retrofit封装的GET请求
    @GET
    Call<String> request(@Url String url);

    //只是用Retrofit封装的Post请求
    @POST
    Call<String> request(@Url String url,@Body RequestBody body);

    //Retrofit RxJava结合使用的Get请求
    @GET
    Observable<String> requestByRxJava(@Url String url);

    //Retrofit RxJava结合使用的Post请求
    @POST
    Observable<String> requestByRxJava(@Url String url,@Body RequestBody body);

}
