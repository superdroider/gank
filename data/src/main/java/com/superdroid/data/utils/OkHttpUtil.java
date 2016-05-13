package com.superdroid.data.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttpUtil {
    private static volatile OkHttpClient mOkHttpClient;

    public static OkHttpClient getInstance() {
        OkHttpClient tOkHttpClient = mOkHttpClient;
        if (mOkHttpClient == null) {
            synchronized (OkHttpUtil.class) {
                tOkHttpClient = mOkHttpClient;
                if (tOkHttpClient == null) {
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(15000, TimeUnit.MILLISECONDS);
                    builder.readTimeout(15000, TimeUnit.MILLISECONDS);
                    tOkHttpClient = builder.build();
                    mOkHttpClient = tOkHttpClient;
                }
            }
        }
        return tOkHttpClient;
    }
}