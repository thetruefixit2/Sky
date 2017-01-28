package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.dabe.skyapp.R;
import com.dabe.skyapp.interfaces.OnLoginCallbackListener;
import com.dabe.skyapp.model.data.bo.RecipientBO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 * Не делал презентеры в активити, но они должны здесь быть.
 */

public class LoginActivity extends PopUpActivity
        implements OnLoginCallbackListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        setContainer(R.id.container);
        initUI();
        initDefaultData();
    }

    public void initUI() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void initDefaultData() {
        showEasyLoginScreen();
    }


    @Override
    public void onOpenEasyLoginScreen() {
        showEasyLoginScreen();
    }

    @Override
    public void onOpenHardLoginScreen() {
        showHardLoginScreen();
    }

    @Override
    public void onCodeRequested(RecipientBO reception) {
        showCodeScreen(reception);
    }

    @Override
    public void onSuccessLogin() {
        showMainContainer();
    }

    @Override
    public void onToolbarTitleChanged(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public void onErrorOccurred(String errorMessage) {
        Snackbar.make(coordinatorLayout, errorMessage, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
