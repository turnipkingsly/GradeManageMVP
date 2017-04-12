package com.student.grademanagermvp.dagger2.injector;

import android.content.Context;

import com.student.grademanagermvp.dagger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by huangbiao on 2016/10/31.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();  // 提供Applicaiton的Context
}
