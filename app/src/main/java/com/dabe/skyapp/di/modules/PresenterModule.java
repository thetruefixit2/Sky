package com.dabe.skyapp.di.modules;


import com.dabe.skyapp.model.DataManager;
import com.dabe.skyapp.model.SharedPreffsManager;
import com.dabe.skyapp.model.interfaces.IDataManager;
import com.dabe.skyapp.utils.Timer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    IDataManager provideDataManager() {
        return new DataManager();
    }

    @Provides
    CompositeSubscription provideCompositeSubscription() {
        return new CompositeSubscription();
    }

    @Provides
    @Singleton
    Timer provideTimer() {
        return new Timer();
    }

    @Provides
    @Singleton
    SharedPreffsManager provideSharedManager() {
        return new SharedPreffsManager();
    }
}
