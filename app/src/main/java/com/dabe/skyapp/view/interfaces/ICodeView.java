package com.dabe.skyapp.view.interfaces;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:12.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface ICodeView extends IBaseView {
    void onSignButtonEnabled(boolean enabled);

    void onDescriptionTextUpdated(String text);

    void onResendButtonTextUpdate(String text);

    void onResendButtonEnableUpdate(boolean enabled);

    void onSuccessLogin();
}
