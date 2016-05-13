package com.superdroid.domain;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.data.repository.ArticleDataRepository;
import com.superdroid.data.source.local.ArticleLocalDataSource;
import com.superdroid.data.source.remote.ArticleRemoteDataSource;

import java.util.List;

import rx.Completable;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/5/13.
 */
public class ArticleUseCase {

    private ArticleDataRepository articleDataRepository;
    private ArticleRemoteDataSource remoteDataSource;
    private ArticleLocalDataSource localDataSource;
    private CompositeSubscription mSubscriptions;

    public ArticleUseCase() {
        remoteDataSource = new ArticleRemoteDataSource();
        localDataSource = new ArticleLocalDataSource();
        this.articleDataRepository = new ArticleDataRepository(localDataSource, remoteDataSource);
        this.mSubscriptions = new CompositeSubscription();
    }

    public void execute(Subscriber<List<ArticleEntity>> subscriber) {
        this.buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
        mSubscriptions.add(subscriber);
    }

    private Observable<List<ArticleEntity>> buildUseCaseObservable() {
        return articleDataRepository.getArticleList("Android", 1);
    }


    public void unSubscribe() {
        if (!mSubscriptions.isUnsubscribed())
            mSubscriptions.unsubscribe();
    }

}
