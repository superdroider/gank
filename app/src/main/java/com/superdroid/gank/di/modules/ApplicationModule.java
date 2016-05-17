package com.superdroid.gank.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/5/17.
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {

        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){return this.application;}

}
