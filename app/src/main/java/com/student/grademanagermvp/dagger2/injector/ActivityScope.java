package com.student.grademanagermvp.dagger2.injector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by huangbiao on 2016/10/31.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
