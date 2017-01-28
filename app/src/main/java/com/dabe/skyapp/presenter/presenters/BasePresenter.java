package com.dabe.skyapp.presenter.presenters;

import android.content.Context;

import com.dabe.skyapp.R;
import com.dabe.skyapp.model.SharedPreffsManager;
import com.dabe.skyapp.model.data.enums.ErrorTypesEnum;
import com.dabe.skyapp.model.interfaces.IDataManager;
import com.dabe.skyapp.presenter.interfaces.IBasePresenter;
import com.dabe.skyapp.view.interfaces.IBaseView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    protected T view;

    @Inject
    protected Context appContext;

    @Inject
    protected IDataManager dataManager;

    @Inject
    protected SharedPreffsManager sharedManager;

    @Inject
    protected CompositeSubscription compositeSubscription; // this is for clear rxJava subscribers.

    public BasePresenter() {
    }

    protected void addSubscriber(Subscription sub) {
        compositeSubscription.add(sub);
    }

    protected void processError(ErrorTypesEnum errorType) {
        String errorString = getErrorByType(errorType);
        if (getView() != null) {
            getView().onErrorOccurred(errorString);
        }
    }

    protected void hideLoading() {
        if (getView() != null) {
            getView().onHideLoading();
        }
    }

    protected String getErrorByType(ErrorTypesEnum type) {
        String errorMessage;

        switch (type) {
            case EMAIL:
                errorMessage = appContext.getString(R.string.error_email);
                break;
            case EMAIL_PASSWORD:
                errorMessage = appContext.getString(R.string.error_email_password);
                break;
            case CODE:
                errorMessage = appContext.getString(R.string.error_code);
                break;
            case TOKEN:
                errorMessage = appContext.getString(R.string.error_token);
                break;
            case INTERNET:
                errorMessage = appContext.getString(R.string.error_internet);
            default:
                errorMessage = appContext.getString(R.string.error_internet);
                break;
        }
        return errorMessage;
    }

    protected void setView(T view) {
        this.view = view;
    }

    protected T getView() {
        return view;
    }

    protected Context getAppContext() {
        return appContext;
    }

    @Override
    public void onStop() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }
}
