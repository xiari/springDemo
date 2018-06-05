package com.demo.mvc.utils;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

/**
 * Created by XYY78 on 2016/9/18.
 */
public class JsonUtil {

    private static Gson gson = new Gson();

    public static String toJsonString(Object src) {

        if (src == null) {
            gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }

}
