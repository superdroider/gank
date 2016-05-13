package com.superdroid.gank.android;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.superdroid.data.entity.ArticleEntity;
import com.superdroid.gank.base.BaseFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/5/12.
 */
public class AndroidArticleFragment extends BaseFragment implements AndroidArticleContact.View {

    private AndroidArticleContact.Presenter presenter;

    public static AndroidArticleFragment getInstance(){
        return new AndroidArticleFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }
    @Override
    public void onPause() {
        super.onPause();
        presenter.unSubscribe();
    }

    @Override
    public void showLoadingPage() {

    }

    @Override
    public void showEmptyPage() {

    }

    @Override
    public void showErrorPage() {

    }

    @Override
    public void showSuccessPage(List<ArticleEntity> articleEntities) {

    }

    @Override
    public void setPresenter(AndroidArticleContact.Presenter presenter) {
        this.presenter = presenter;
    }
}
