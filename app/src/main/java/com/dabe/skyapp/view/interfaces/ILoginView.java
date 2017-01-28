package com.dabe.skyapp.view.interfaces;

import com.dabe.skyapp.model.data.bo.RecipientBO;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:12.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface ILoginView extends IBaseView {
    void onSignButtonEnabled(boolean enabled);

    void onSuccessRequestCode(RecipientBO recipient);

    void onSuccessSignIn();

    void onToolbarTitleChanged(String title);
}
