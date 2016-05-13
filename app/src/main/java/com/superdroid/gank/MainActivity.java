package com.superdroid.gank;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.superdroid.data.repository.ArticleDataRepository;
import com.superdroid.data.source.local.ArticleLocalDataSource;
import com.superdroid.data.source.remote.ArticleRemoteDataSource;
import com.superdroid.gank.android.AndroidArticleFragment;
import com.superdroid.gank.android.AndroidArticlePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_container)
    FrameLayout frag_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AndroidArticleFragment fragment = AndroidArticleFragment.getInstance();
        AndroidArticlePresenter presenter = new AndroidArticlePresenter(fragment);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fl_container, fragment);
        transaction.commit();
    }
}
