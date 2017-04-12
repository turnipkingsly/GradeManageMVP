package com.student.grademanagermvp.model.request;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by huangbiao on 2016/10/30.
 */

public abstract class BasePostReq extends BaseRequest{


    public RequestBody getPostData() throws JSONException {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), getJson().toString());
        return requestBody;
    }

    public abstract JSONObject getJson() throws JSONException;

    public int getRequestType() {
        requestType = 2;
        return requestType;
    }
}
