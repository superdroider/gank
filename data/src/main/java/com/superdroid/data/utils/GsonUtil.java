package com.superdroid.data.utils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/5/12.
 */
public class GsonUtil {
    public static Gson getInstance() {
        return new Gson();
    }

    public static boolean isStandardJson(String jsonStr) {
        try {
            if (jsonStr.startsWith("{")) {
                new JSONObject(jsonStr);
            } else if (jsonStr.startsWith("[")) {
                new JSONArray(jsonStr);
            } else {
                return false;
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
