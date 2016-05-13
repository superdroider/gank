package com.superdroid.data.source.local;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.data.source.ArticleDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ArticleLocalDataSource implements ArticleDataSource {


    @Override
    public Observable<List<ArticleEntity>> getArticleList(String type, int page) {
        return null;
    }
}
