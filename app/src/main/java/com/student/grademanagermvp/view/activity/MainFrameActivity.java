package com.student.grademanagermvp.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.student.grademanagermvp.R;
import com.student.grademanagermvp.contract.MainFrameContract;
import com.student.grademanagermvp.dagger2.injector.ActivityComponent;
import com.student.grademanagermvp.dagger2.injector.AppComponent;
import com.student.grademanagermvp.dagger2.injector.DaggerActivityComponent;
import com.student.grademanagermvp.dagger2.injector.DaggerAppComponent;
import com.student.grademanagermvp.dagger2.module.ActivityModule;
import com.student.grademanagermvp.dagger2.module.AppModule;
import com.student.grademanagermvp.model.response.BaseRes;
import com.student.grademanagermvp.presenter.MainFramePresenter;
import com.student.grademanagermvp.view.ZLAndroidApplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFrameActivity extends Activity implements MainFrameContract.MainFrameView{

    @BindView(R.id.button1) Button button1;
    @BindView(R.id.button2) Button button2;
    @BindView(R.id.button3) Button button3;

    //当该对象的注入方式为在 构造方法声明时， 该处不能用父类声明 必须使用对于的presenter类进行定义声明
    @Inject
    MainFramePresenter presenter;

    private ActivityComponent mActivityComponent;

	//测试 git ss sss

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        initInject();
    }

    public void init(){
        mActivityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        mActivityComponent.inject(this);
        presenter.attachView(this);
        presenter.start();
    }

    private void initInject() {
        // 构建Component并注入
        getActivityComponent().inject(this);
        presenter.attachView(this);
    }

    //  建议写在基类Activity里
    public ActivityComponent getActivityComponent(){
        return  DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    //  建议写在基类Activity里
    public ActivityModule getActivityModule(){
        return new ActivityModule();
    }

    // 建议写在MyApplication类里
    public AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule((ZLAndroidApplication) getApplicationContext()))
                .build();
    }


    @OnClick({R.id.button1, R.id.button2,R.id.button3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                checkPkgStatus();
                break;
            case R.id.button2:
                getPkgStatus();
                break;
            case R.id.button3:
                presenter.testRxJava();
                break;
            default:
                break;
        }
    }

    @Override
    public void setPresenter(MainFrameContract.IMainFramePresenter presenter) {
        this.presenter = (MainFramePresenter) presenter;
    }

    public void getPkgStatus(){
        presenter.getDataFromNet();
    }

    public void checkPkgStatus(){
        presenter.checkPkgStatus();
    }

    @Override
    public void showData(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        Log.e("msg",msg+"");
    }

    @Override
    public void showBaseRes(BaseRes res) {
        System.out.println(res.getCode());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
