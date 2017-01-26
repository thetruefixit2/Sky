package com.dabe.skyapp.view.ui.fragments;

import android.content.Context;

import com.dabe.skyapp.interfaces.OnLoginCallbackListener;
import com.dabe.skyapp.view.interfaces.IBaseView;

/**
 * Created by Daniil Belevtsev on 26.01.2017 1:08.
 * Project: SkyApp; Skype: pandamoni1
 */

public class BaseLoginFragment extends BaseFragment implements IBaseView {

    private OnLoginCallbackListener activityCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginCallbackListener) {
            activityCallback = (OnLoginCallbackListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLoginCallbackListener");
        }
    }

    @Override
    public void showError(String errorMessage) {
        if(activityCallback != null) {
            activityCallback.onErrorOccurred(errorMessage);
        }
    }

    @Override
    public void showLoading(String loadingMessage) {
        if(activityCallback != null) {
            activityCallback.onShowLoading(loadingMessage);
        }
    }

    @Override
    public void hideLoading() {
        if(activityCallback != null) {
            activityCallback.onHideLoading();
        }
    }


    public OnLoginCallbackListener getActivityCallback() {
        return activityCallback;
    }
}
