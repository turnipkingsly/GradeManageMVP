package com.student.grademanagermvp.framework.gson;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.lang.reflect.Type;

public class HttpJsonAdapter {

    private volatile static HttpJsonAdapter instance = null;

    private HttpJsonAdapter() {
    }

    public static HttpJsonAdapter getInstance() {
        if (instance == null) {
            synchronized (HttpJsonAdapter.class) {
                if (instance == null) {
                    instance = new HttpJsonAdapter();
                }
            }
        }

        return instance;
    }

    public <T> T get(String str, Class<T> clazz) throws Exception {
        Gson gson =
                new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        if (gson == null) {
            return null;
        }

        try {
            return (T) gson.fromJson(str, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据处理异常", e);
        }
    }

    /**
     * json转成对象
     *
     * @param jsonStr
     * @param typeOfT
     * @return
     */
    public <T> T fromJson(String jsonStr, Type typeOfT) throws Exception {
        try {
            if (jsonStr == null || TextUtils.isEmpty(jsonStr)) {
                return null;
            }
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            try {
                return (T) gson.fromJson(jsonStr, typeOfT);
            } catch (Exception ex) {
                throw new Exception(
                        jsonStr + " 无法转换为 " + typeOfT.toString() + " 对象!", ex);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String getJsonString(Object object) {
        Gson gson =
                new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        String str = gson.toJson(object);


        return str;
    }

    public JsonArray getJsonJsonArray(Object object) {
        Gson gson =
                new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        JsonArray str = gson.toJsonTree(object).getAsJsonArray();


        return str;
    }


}
