package com.superdroid.gank;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.FrameLayout;

import com.superdroid.gank.android.AndroidArticleFragment;
import com.superdroid.gank.android.AndroidArticlePresenter;
import com.superdroid.gank.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_container)
    FrameLayout frag_container;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("tag", "navigator=" + navigator);
        navigator.navigateToArticleDetail();
        AndroidArticleFragment fragment = AndroidArticleFragment.getInstance();
        AndroidArticlePresenter presenter = new AndroidArticlePresenter(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_container, fragment);
        transaction.commit();
    }
}
