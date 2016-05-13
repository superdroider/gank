package com.superdroid.data.repository;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.data.source.local.ArticleLocalDataSource;
import com.superdroid.data.source.remote.ArticleRemoteDataSource;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2016/5/11.
 */
public class ArticleDataRepository {

    private ArticleLocalDataSource localDataSource;
    private ArticleRemoteDataSource remoteDataSource;

    public ArticleDataRepository(ArticleLocalDataSource localDataSource, ArticleRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    public Observable<List<ArticleEntity>> getArticleList(String type, int page) {
        return remoteDataSource.getArticleList(type, page);
    }
}
