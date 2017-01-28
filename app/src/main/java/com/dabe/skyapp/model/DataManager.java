package com.dabe.skyapp.model;

import android.content.Context;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppConsts;
import com.dabe.skyapp.model.api.interfaces.ISkyApi;
import com.dabe.skyapp.model.data.dto.response.AppTokenDTO;
import com.dabe.skyapp.model.data.dto.response.AuthTokenDTO;
import com.dabe.skyapp.model.data.dto.response.ProductsDTO;
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

    @Override
    public Observable<AuthTokenDTO> postEasyLogin(String email) {
        return skyApi.easyLogin(email)
                .map(response -> (AuthTokenDTO) response.getResult())
                .compose(applyShedulers());
    }

    @Override
    public Observable<AppTokenDTO> postHardLogin(String email, String password) {
        return skyApi.hardLogin(email, password)
                .map(response -> (AppTokenDTO) response.getResult())
                .compose(applyShedulers());
    }

    @Override
    public Observable<AppTokenDTO> postVerifyCode(String code, String authToken) {
        return skyApi.verifyCode(code, authToken)
                .map(response -> (AppTokenDTO) response.getResult())
                .compose(applyShedulers());
    }

    @Override
    public Observable<ProductsDTO> postSyncData(String token) {
        return skyApi.syncData(token)
                .map(response -> (ProductsDTO) response.getResult())
                .compose(applyShedulers());
    }

    @SuppressWarnings("unchecked")
    private <T> Observable.Transformer<T, T> applyShedulers() {
        return (Observable.Transformer<T, T>) shedulersTransformer;
    }

}
