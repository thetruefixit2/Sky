package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.interfaces.OnProductsCallbackListener;
import com.dabe.skyapp.presenter.presenters.ProductsMainPresenter;
import com.dabe.skyapp.view.interfaces.IProductsMainView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:27.
 * Project: SkyApp; Skype: pandamoni1
 * Не делал презентеры в активити, но они должны здесь быть.
 */

public class ProductsActivity extends PopUpActivity
        implements OnProductsCallbackListener, IProductsMainView {

    @Inject
    protected ProductsMainPresenter presenter;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        setContainer(R.id.container);
        presenter.init(this);
        initUI();
        initDefaultData();
    }

    private void initUI() {
        setSupportActionBar(toolbar);
    }

    private void initDefaultData() {
        showProductsScreen();
        presenter.startDailyUpdate();
    }

    @Override
    public void onErrorOccurred(String errorMessage) {
        Snackbar.make(coordinatorLayout, errorMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onLogoutRequest() {
        presenter.clearData();
    }

    @Override
    public void onSuccessLogOut() {
        showLoginContainer();
    }
}
