package com.superdroid.gank.di.components;

import android.content.Context;

import com.superdroid.gank.base.BaseActivity;
import com.superdroid.gank.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2016/5/17.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();
}
