package com.student.grademanagermvp.framework;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangbiao on 2016/10/29.
 */

public class WoConfiguration {

    public static String getStatisticsHeaders() {
        HashMap<String, String> infoMap = new HashMap<String, String>();
        infoMap.put("channelid", "28000000");
        infoMap.put("imsi", "1111111111");
        infoMap.put("imei", "2222222222");
        infoMap.put("osversion", "5.3.2");
        return buildStatisticsInfo(infoMap);
    }

    private static String buildStatisticsInfo(HashMap<String, String> infoMap) {
        StringBuilder ret = new StringBuilder();
        Set<Map.Entry<String, String>> set = infoMap.entrySet();
        for (Map.Entry<String, String> entry : set) {
            if (ret.length() > 0) {
                ret.append("&");
            }
            ret.append(entry.getKey()).append("=").append(entry.getValue());
        }
        return ret.toString();
    }
}
