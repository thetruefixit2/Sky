package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.mock.ResponseException;
import com.dabe.skyapp.model.data.dto.response.AppTokenDTO;
import com.dabe.skyapp.view.interfaces.ILoginView;

import rx.Subscriber;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:16.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoginHardPresenter extends BasePresenter<ILoginView> {

    public void init(ILoginView view) {
        TheApp.getComponent().inject(this);
        setView(view);
        initTitle();
    }

    private void initTitle() {
        String title = getAppContext().getString(R.string.login);
        if (getView() != null) {
            getView().onToolbarTitleChanged(title);
        }
    }

    public void validateData(String login, String password) {
        boolean validateResult = false;
        if (!login.isEmpty() && !password.isEmpty()) {
            validateResult = true;
        }
        if (getView() != null) {
            getView().onSignButtonEnabled(validateResult);
        }
    }


    public void login(String email, String password) {
        showLoading();
        dataManager.postHardLogin(email, password)
                .subscribe(new Subscriber<AppTokenDTO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        processError(((ResponseException) e).getErrorType());
                        hideLoading();
                    }

                    @Override
                    public void onNext(AppTokenDTO appTokenDTO) {
                        sharedManager.saveAppToken(appTokenDTO.getToken());
                        if (getView() != null) {
                            getView().onSuccessSignIn();
                        }
                        hideLoading();
                    }
                });
    }

    private void showLoading() {
        String message = getAppContext().getString(R.string.loading_in_progress_login);
        if (getView() != null) {
            getView().onShowLoading(message);
        }
    }
}
