package com.dabe.skyapp.interfaces;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:56.
 * Project: SkyApp; Skype: pandamoni1
 */

public interface OnProgressListener {

    void onShowLoading(String title);

    void onHideLoading();

    void onErrorOccurred(String errorMessage);

}
