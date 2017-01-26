package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.view.interfaces.ILoginView;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:16.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoginHardPresenter extends BasePresenter<ILoginView> {

    public void init(ILoginView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }

    public void validateTexts(String login, String password) {
        boolean validateResult = false;
        if (!login.isEmpty() && !password.isEmpty()) {
            validateResult = true;
        }
        if (getView() != null) {
            getView().onLoginButtonEnabled(validateResult);
        }
    }


    public void login(String login, String password) {

    }
}
