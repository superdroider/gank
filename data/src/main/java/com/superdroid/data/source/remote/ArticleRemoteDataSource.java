package com.superdroid.data.source.remote;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;
import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.data.entity.CommonResponseEntity;
import com.superdroid.data.exception.CommonResponseException;
import com.superdroid.data.source.ArticleDataSource;
import com.superdroid.data.utils.ApiService;
import com.superdroid.data.utils.GsonUtil;
import com.superdroid.data.utils.RetrofitUtil;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ArticleRemoteDataSource implements ArticleDataSource {
    @Override
    public Observable<List<ArticleEntity>> getArticleList(String type, int page) {
        ApiService apiService = RetrofitUtil.getInstance().create(ApiService.class);
        return apiService.getArticleList(type, page).flatMap(new Func1<ResponseBody, Observable<List<ArticleEntity>>>() {
            @Override
            public Observable<List<ArticleEntity>> call(final ResponseBody responseBody) {
                return Observable.create(new Observable.OnSubscribe<List<ArticleEntity>>() {
                    @Override
                    public void call(Subscriber<? super List<ArticleEntity>> subscriber) {
                        try {
                            String jsonStr = responseBody.string();
                            checkResponseStr(jsonStr, subscriber);
                            CommonResponseEntity<List<ArticleEntity>> commonResponseEntity = GsonUtil.getInstance().fromJson(jsonStr, new TypeToken<CommonResponseEntity<List<ArticleEntity>>>() {
                            }.getType());
                            checkParseResults(commonResponseEntity, subscriber);
                            subscriber.onNext(commonResponseEntity.getResults());
                            subscriber.onCompleted();
                        } catch (IOException e) {
                            subscriber.onError(e);
                        }
                    }
                });
            }
        });
    }

    /**
     * 检查响应内容
     *
     * @param responseStr
     * @param subscriber
     */
    private void checkResponseStr(String responseStr, Subscriber subscriber) {
        if (TextUtils.isEmpty(responseStr)) {
            subscriber.onError(new NullPointerException("相应内容为空"));
        } else if (!GsonUtil.isStandardJson(responseStr)) {
            subscriber.onError(new JSONException("响应内容不是标准的Json类型"));
        }
    }

    /**
     * 检查解析结果
     *
     * @param commonResponseEntity
     * @param subscriber
     */
    private void checkParseResults(CommonResponseEntity commonResponseEntity, Subscriber subscriber) {
        if (commonResponseEntity == null) {
            subscriber.onError(new NullPointerException("CommonResponseEntity is null"));
        } else if (commonResponseEntity.isError()) {
            subscriber.onError(new CommonResponseException("CommonResponseEntity's error is true"));
        }else if(commonResponseEntity.getResults()==null){
            subscriber.onError(new CommonResponseException("CommonResponseEntity's results is null"));
        }
    }

}
