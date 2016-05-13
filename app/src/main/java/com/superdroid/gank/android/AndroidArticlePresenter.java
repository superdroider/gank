package com.superdroid.gank.android;

import android.util.Log;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.domain.ArticleUseCase;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/5/12.
 */
public class AndroidArticlePresenter implements AndroidArticleContact.Presenter {

    private ArticleUseCase articleUseCase;

    private AndroidArticleContact.View mArticleView;

    public AndroidArticlePresenter(AndroidArticleContact.View mArticleView) {

        this.mArticleView = mArticleView;
        mArticleView.setPresenter(this);
        articleUseCase = new ArticleUseCase();
    }

    @Override
    public void subscribe() {
        loadArticles(false);
    }

    @Override
    public void unSubscribe() {
        articleUseCase.unSubscribe();
    }

    @Override
    public void loadArticles(boolean isForceUpdate) {

        mArticleView.showLoadingPage();

        articleUseCase.execute(new Subscriber<List<ArticleEntity>>() {
            @Override
            public void onCompleted() {
                Log.e("tag", "==onCompleted==");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("tag", "==onError==" + e);
            }

            @Override
            public void onNext(List<ArticleEntity> articleEntities) {
                if (articleEntities.size() == 0) {
                    mArticleView.showEmptyPage();
                } else {
                    mArticleView.showSuccessPage(articleEntities);
                }
                Log.e("tag", "==onNext==" + articleEntities);
            }
        });
    }
}
