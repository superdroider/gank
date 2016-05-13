package com.superdroid.data.source;

import com.superdroid.data.entity.ArticleEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2016/5/11.
 */
public interface ArticleDataSource {

    Observable<List<ArticleEntity>> getArticleList(String type, int page);

}
