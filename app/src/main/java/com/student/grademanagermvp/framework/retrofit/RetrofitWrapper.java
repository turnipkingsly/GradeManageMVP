package com.student.grademanagermvp.framework.retrofit;

import com.student.grademanagermvp.framework.WoConfiguration;
import com.student.grademanagermvp.utils.PhoneInfoTools;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * retrofit网络请求封装类
 * Created by huangbiao on 2016/10/29.
 */

public class RetrofitWrapper {

    //单例
    private static RetrofitWrapper INSTANCE;
    // Retrofit 对象
    private Retrofit mRetrofit;

    private RetrofitWrapper(String BASE_URL){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)  //添加baseurl
                .client(genericClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create()) //添加返回为字符串的支持
                .addConverterFactory(GsonConverterFactory.create()) //create中可以传入其它json对象，默认Gson
                .build();
    }

    //设置headers
    public  OkHttpClient genericClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("User-Agent", PhoneInfoTools.getUA())
                                .addHeader("statisticsinfo", WoConfiguration.getStatisticsHeaders())
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return httpClient;
    }

    public static RetrofitWrapper getInstance(String BASE_URL) {
        if(INSTANCE == null) {
            synchronized(RetrofitWrapper.class) {
                if(INSTANCE == null) {
                    INSTANCE = new RetrofitWrapper(BASE_URL);
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 转换为对象的Service
     * @param service
     * @param <T>
     * @return 传入的类型
     */
    public <T> T create(Class<T> service){
        return mRetrofit.create(service);
    }
}
