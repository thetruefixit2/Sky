package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;

import com.dabe.skyapp.R;
import com.dabe.skyapp.interfaces.OnLoginCallbackListener;
import com.dabe.skyapp.model.data.enums.CodeTypeEnum;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoginActivity extends RouteActivity
        implements OnLoginCallbackListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setContainer(R.id.container);
        showEasyLoginScreen();
    }

    @Override
    public void onShowLoading(String title) {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onErrorOccurred(String errorMessage) {

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
    public void onCodeRequested(CodeTypeEnum codeType) {
        showCodeScreen(codeType);
    }

    @Override
    public void onSuccessLogin() {
        showMainContainer();
    }
}
