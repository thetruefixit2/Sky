package com.dabe.skyapp.view.interfaces;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface IBaseView {
    void showError(String errorMessage);

    void showLoading(String loadingMessage);

    void hideLoading();
}
