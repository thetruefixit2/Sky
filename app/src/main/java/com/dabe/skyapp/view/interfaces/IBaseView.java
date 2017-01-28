package com.dabe.skyapp.view.interfaces;


/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface IBaseView {
    void onErrorOccurred(String errorMessage);

    void onShowLoading(String loadingMessage);

    void onHideLoading();
}
