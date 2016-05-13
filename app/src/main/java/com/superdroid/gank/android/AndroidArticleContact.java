package com.superdroid.gank.android;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.gank.base.BasePresenter;
import com.superdroid.gank.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2016/5/12.
 */
public interface AndroidArticleContact {

    interface View extends BaseView<Presenter> {
        void showLoadingPage();

        void showEmptyPage();

        void showErrorPage();

        void showSuccessPage(List<ArticleEntity> articleEntities);
    }

    interface Presenter extends BasePresenter {
        void loadArticles(boolean isForceUpdate);
    }
}
