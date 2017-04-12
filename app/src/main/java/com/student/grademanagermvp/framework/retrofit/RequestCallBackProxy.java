package com.student.grademanagermvp.framework.retrofit;

import com.student.grademanagermvp.model.response.BaseRes;

/**
 * retrofit网络请求回调
 * Created by huangbiao on 2016/10/30.
 */

public interface RequestCallBackProxy {

    void handleSuccessResponse(Object baseRes);
    void handleFailureResponse(BaseRes baseRes);

}
