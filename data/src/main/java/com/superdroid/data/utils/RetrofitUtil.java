package com.superdroid.data.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by Administrator on 2016/5/11.
 */
public class RetrofitUtil {
    private static volatile Retrofit retrofit;

    public static Retrofit getInstance() {
        Retrofit tRetrofit = retrofit;
        if (retrofit == null) {
            synchronized (RetrofitUtil.class) {
                tRetrofit = retrofit;
                if (tRetrofit == null) {
                    tRetrofit = new Retrofit.Builder()
                            .baseUrl("http://gank.io/api/data/")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(OkHttpUtil.getInstance())
                            .build();
                    retrofit = tRetrofit;
                }
            }
        }
        return tRetrofit;
    }

}
