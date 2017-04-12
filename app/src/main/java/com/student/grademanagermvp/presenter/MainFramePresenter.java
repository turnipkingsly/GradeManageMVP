package com.student.grademanagermvp.presenter;

import android.util.Log;

import com.student.grademanagermvp.contract.MainFrameContract;
import com.student.grademanagermvp.framework.retrofit.RequestCallBackProxy;
import com.student.grademanagermvp.model.request.FavTypeReq;
import com.student.grademanagermvp.model.request.QueryPkgStatusReq;
import com.student.grademanagermvp.model.response.BaseRes;
import com.student.grademanagermvp.model.response.QueryPkgStatusRes;
import com.student.grademanagermvp.model.response.SnsPersonInfoRes;

import javax.inject.Inject;

/**
 * Created by huangbiao on 2016/10/28.
 */

public class MainFramePresenter implements MainFrameContract.IMainFramePresenter, RequestCallBackProxy {

    //主页activity的维护
    private MainFrameContract.MainFrameView mainFrameView;

    @Inject
    public MainFramePresenter() {

    }

    @Override
    public void start() {
    }

    @Override
    public void getDataFromNet() {
        QueryPkgStatusReq pkgStatusReq = new QueryPkgStatusReq();
        pkgStatusReq.setProductid("2672");
        pkgStatusReq.setUserindex("104863233");
        pkgStatusReq.requestRetrofit(this);
    }

    @Override
    public void checkPkgStatus() {
        FavTypeReq favTypeReq = new FavTypeReq();
        favTypeReq.setFavType("1");
        favTypeReq.setUserid("91048632335");
        favTypeReq.setVerifycode("s18vRjdlRrq");
        favTypeReq.requestRetrofit(this);
    }

    public void testRxJava(){
        Log.e("testRxJava","start");
        QueryPkgStatusReq pkgStatusReq = new QueryPkgStatusReq();
        pkgStatusReq.setProductid("2671");
        pkgStatusReq.setUserindex("104863233");
        pkgStatusReq.requestByRxJava(this);
    }

    @Override
    public void attachView(MainFrameContract.MainFrameView view) {
        this.mainFrameView = view;
    }

    @Override
    public void detachView() {
        this.mainFrameView = null;
    }


    @Override
    public void handleSuccessResponse(Object baseRes) {
        if (baseRes != null && baseRes instanceof BaseRes) {
            BaseRes res = (BaseRes) baseRes;
            if (res instanceof QueryPkgStatusRes) {
                QueryPkgStatusRes queryRes = (QueryPkgStatusRes) res;
                if (mainFrameView != null) {
                    mainFrameView.showData(queryRes.getCode());
                }
            }else if (res instanceof SnsPersonInfoRes){
                SnsPersonInfoRes snsPersonInfoRes = (SnsPersonInfoRes) res;
                if (mainFrameView != null) {
                    mainFrameView.showData(snsPersonInfoRes.getMessage().getDetailAddress());
                }
            }
        }
    }

    @Override
    public void handleFailureResponse(BaseRes baseRes) {
        if (baseRes != null) {
            if (mainFrameView != null) {
                mainFrameView.showData(baseRes.getCode());
            }
        }
    }
}
