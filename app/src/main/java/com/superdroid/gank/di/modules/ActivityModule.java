package com.superdroid.gank.di.modules;

import android.app.Activity;

import com.superdroid.gank.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/5/17.
 */
@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return activity;
    }

}
