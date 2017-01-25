package com.dabe.skyapp.presenter;

import com.dabe.skyapp.model.IDataManager;
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
    protected IDataManager dataManager;

    @Inject
    protected CompositeSubscription compositeSubscription; // this is for clear rxJava subscribers.

    public BasePresenter() {
    }

    protected void addSubscriber(Subscription sub) {
        compositeSubscription.add(sub);
    }

    @Override
    public void onStop() {
        if (compositeSubscription != null) {
            compositeSubscription.clear();
        }
    }

    protected T getView() {
        return view;
    }

    protected void setView(T view) {
        this.view = view;
    }
}
