package com.dabe.skyapp;

import android.app.Application;

import com.dabe.skyapp.di.BaseComponent;
import com.dabe.skyapp.di.DaggerBaseComponent;
import com.dabe.skyapp.di.modules.AppModule;
import com.dabe.skyapp.di.modules.ModelModule;
import com.dabe.skyapp.di.modules.PresenterModule;
import com.dabe.skyapp.di.modules.ViewModule;


/**
 /**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 * The app file, gives component for dagger.
 */

public class TheApp extends Application {
    private static BaseComponent component;

    public static BaseComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    /**
     * Build dagger2 component
     */
    private BaseComponent buildComponent() {
        return DaggerBaseComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .modelModule(new ModelModule())
                .presenterModule(new PresenterModule())
                .viewModule(new ViewModule())
                .build();
    }

}
