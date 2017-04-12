package com.student.grademanagermvp.dagger2.module;

import android.content.Context;

import com.student.grademanagermvp.view.ZLAndroidApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by huangbiao on 2016/10/31.
 */
@Module
public class AppModule {

    private final ZLAndroidApplication application;

    public AppModule(ZLAndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

}
