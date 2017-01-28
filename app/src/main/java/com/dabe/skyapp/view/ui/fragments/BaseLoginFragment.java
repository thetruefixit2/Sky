package com.dabe.skyapp.view.ui.fragments;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

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
    public void onErrorOccurred(String errorMessage) {
        if (activityCallback != null) {
            activityCallback.onErrorOccurred(errorMessage);
        }
    }

    @Override
    public void onShowLoading(String loadingMessage) {
        hideKeyboard();
        if (activityCallback != null) {
            activityCallback.onShowLoading(loadingMessage);
        }
    }

    @Override
    public void onHideLoading() {
        if (activityCallback != null) {
            activityCallback.onHideLoading();
        }
    }

    public void hideKeyboard() {
        if (getView() != null && getView().getWindowToken() != null) {
            final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
        }
    }

    public OnLoginCallbackListener getActivityCallback() {
        return activityCallback;
    }
}
