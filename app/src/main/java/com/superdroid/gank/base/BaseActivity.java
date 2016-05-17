package com.superdroid.gank.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.superdroid.gank.AndroidApplication;
import com.superdroid.gank.di.components.ApplicationComponent;
import com.superdroid.gank.navigation.Navigator;

import javax.inject.Inject;


/**
 * Created by Administrator on 2016/5/17.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    protected Navigator navigator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("tag", getClass().getSimpleName());
        getApplicationComponent().inject(this);

        Log.e("tag", "compontent context = " + getApplicationComponent().context());
        Log.e("tag", "application context = " + getApplicationContext());
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

}
