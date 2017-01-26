package com.dabe.skyapp.interfaces;

import com.dabe.skyapp.model.data.enums.CodeTypeEnum;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:55.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface OnLoginCallbackListener extends OnProgressListener {
    void onOpenEasyLoginScreen();
    void onOpenHardLoginScreen();
    void onCodeRequested(CodeTypeEnum codeType);
    void onSuccessLogin();

}
