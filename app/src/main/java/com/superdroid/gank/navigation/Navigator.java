package com.superdroid.gank.navigation;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2016/5/17.
 */
public class Navigator {
    @Inject
    public Navigator() {
    }

    public void navigateToArticleDetail() {
        Log.e("tag", "===navigateToArticleDetail===");
    }
}
