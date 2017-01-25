package com.dabe.skyapp.di.modules;


import com.dabe.skyapp.model.DataManager;
import com.dabe.skyapp.model.IDataManager;

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
}
