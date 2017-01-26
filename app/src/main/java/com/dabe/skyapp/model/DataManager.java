package com.dabe.skyapp.model;

import android.content.Context;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppConsts;
import com.dabe.skyapp.model.api.interfaces.ISkyApi;
import com.dabe.skyapp.model.interfaces.IDataManager;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public class DataManager implements IDataManager {

    private final Observable.Transformer shedulersTransformer;

    @Inject
    protected Context context;

    @Inject
    protected ISkyApi skyApi;

    @Inject
    @Named(AppConsts.UI_THREAD)
    protected Scheduler uiThread;

    @Inject
    @Named(AppConsts.IO_THREAD)
    protected Scheduler ioThread;


    public DataManager() {
        TheApp.getComponent().inject(this);
        shedulersTransformer = observable -> ((Observable) observable).subscribeOn(ioThread)
                .observeOn(uiThread)
                .unsubscribeOn(ioThread);
    }


    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applyShedulers() {
        return (Observable.Transformer<T, T>) shedulersTransformer;
    }

}
