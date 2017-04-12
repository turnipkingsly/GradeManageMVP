package com.student.grademanagermvp.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

/**
 * Created by huangbiao on 2016/4/23.
 */
public class ZLAndroidApplication extends Application {

    private volatile static ZLAndroidApplication ourApplication;

    private Activity mActivity;

    public static ZLAndroidApplication Instance() {
        if (ourApplication == null) {
            synchronized (ZLAndroidApplication.class) {
                if (ourApplication == null) {
                    ourApplication = new ZLAndroidApplication();
                }
            }
        }
        return ourApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourApplication = this;

    }

    public Context getContext() {
        return ourApplication.getApplicationContext();
    }

    public Activity getmActivity() {
        return mActivity;
    }
}
