package com.student.grademanagermvp.model.request;

import com.student.grademanagermvp.framework.Correspond;
import com.student.grademanagermvp.model.response.BaseRes;
import com.student.grademanagermvp.model.response.QueryPkgStatusRes;

/**
 * Created by huangbiao on 2016/10/30.
 */

public class QueryPkgStatusReq extends BaseRequest{

    private String productid;
    private String userindex;

    @Override
    public Class<? extends BaseRes> getResClass() {
        return QueryPkgStatusRes.class;
    }

    @Override
    public String generUrl() {
        StringBuilder url = new StringBuilder("read/fee/getPkgOrdered/");
        url.append(Correspond.SOURCE);
        url.append("?productid=").append(productid);
        url.append("&userindex=").append(userindex);
        return url.toString();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getUserindex() {
        return userindex;
    }

    public void setUserindex(String userindex) {
        this.userindex = userindex;
    }
}
