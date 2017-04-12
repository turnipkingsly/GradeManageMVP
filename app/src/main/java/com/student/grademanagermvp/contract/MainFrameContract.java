package com.student.grademanagermvp.contract;

import com.student.grademanagermvp.model.response.BaseRes;
import com.student.grademanagermvp.presenter.BasePresenter;
import com.student.grademanagermvp.view.BaseView;

/**
 * Created by huangbiao on 2016/10/28.
 */

public interface MainFrameContract {

    interface MainFrameView extends BaseView<IMainFramePresenter>{

        void showData(String msg);
        void showBaseRes(BaseRes res);
    }

    interface IMainFramePresenter extends BasePresenter{

        void attachView(MainFrameView view);
        void detachView();
        void getDataFromNet();
        void checkPkgStatus();
        void testRxJava();
    }
}
