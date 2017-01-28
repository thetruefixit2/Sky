package com.dabe.skyapp.interfaces;

import com.dabe.skyapp.model.data.bo.RecipientBO;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:55.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface OnLoginCallbackListener extends OnProgressListener {
    void onOpenEasyLoginScreen();
    void onOpenHardLoginScreen();

    void onCodeRequested(RecipientBO recipient);
    void onSuccessLogin();

    void onToolbarTitleChanged(String title);
}
