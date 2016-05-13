package com.superdroid.data.utils;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/5/11.
 */
public interface ApiService {
    @GET("{type}/10/{page}")
    Observable<ResponseBody> getArticleList(@Path("type") String type, @Path("page") int page);
}
