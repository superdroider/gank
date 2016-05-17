package com.superdroid.gank;

import android.app.Application;

import com.superdroid.gank.di.components.ApplicationComponent;
import com.superdroid.gank.di.components.DaggerApplicationComponent;
import com.superdroid.gank.di.modules.ApplicationModule;

/**
 * Created by Administrator on 2016/5/17.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.applicationComponent = DaggerApplicationComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

}
