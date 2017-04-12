package com.student.grademanagermvp.model.request;

import com.student.grademanagermvp.model.response.BaseRes;
import com.student.grademanagermvp.model.response.SnsPersonInfoRes;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by huangbiao on 2016/10/30.
 */

public class FavTypeReq extends BasePostReq{

    private String favType;
    private String userid;
    private String verifycode;

    @Override
    public JSONObject getJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("likecatalog", this.favType);
        return json;
    }

    @Override
    public Class<? extends BaseRes> getResClass() {
        return SnsPersonInfoRes.class;
    }

    @Override
    public String generUrl() {
        StringBuilder url = new StringBuilder("sns/profile/update/7/");
        url.append(userid).append("/").append(verifycode);
        return url.toString();
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setVerifycode(String verifycode) {
        this.verifycode = verifycode;
    }

    public void setFavType(String favType) {
        this.favType = favType;
    }
}
