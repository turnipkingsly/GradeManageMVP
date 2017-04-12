package com.student.grademanagermvp.dagger2.injector;

import com.student.grademanagermvp.dagger2.module.ActivityModule;
import com.student.grademanagermvp.view.activity.MainFrameActivity;

import dagger.Component;

/**
 * 依赖注入着 使用依赖的提供者
 * Created by huangbiao on 2016/10/31.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainFrameActivity activity);
}
