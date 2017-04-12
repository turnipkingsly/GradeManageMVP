package com.student.grademanagermvp.dagger2.module;

import com.student.grademanagermvp.framework.Correspond;
import com.student.grademanagermvp.framework.retrofit.RetrofitWrapper;

import dagger.Module;
import dagger.Provides;

/**
 * 依赖提供者
 * Created by huangbiao on 2016/10/31.
 */
@Module
public class ActivityModule {

//    @Provides
//    public MainFrameContract.IMainFramePresenter provideMainPresenter(){
//        return new MainFramePresenter();
//    }
    @Provides
    public RetrofitWrapper provideRetrofitWrapper(){
        return RetrofitWrapper.getInstance(Correspond.REGULAR_URL);
    }
}
