package com.dabe.skyapp.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.dabe.skyapp.app.AppConsts;
import com.dabe.skyapp.mock.MockApi;
import com.dabe.skyapp.model.api.interfaces.ISkyApi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */
@Module
public class ModelModule {

    @Provides
    @Singleton
    ISkyApi provideMockApi() {
        // some actions with mocks
       return new MockApi();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context appContext) {
        return PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    @Provides
    @Singleton
    @Named(AppConsts.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(AppConsts.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }


}
