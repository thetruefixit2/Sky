package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.mock.ResponseException;
import com.dabe.skyapp.model.data.bo.RecipientBO;
import com.dabe.skyapp.view.interfaces.ILoginView;

import rx.Subscriber;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:15.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoginEasyPresenter extends BasePresenter<ILoginView> {

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

    public void validateData(String login) {
        boolean validateResult = false;
        if (!login.isEmpty()) {
            validateResult = true;
        }
        if (getView() != null) {
            getView().onSignButtonEnabled(validateResult);
        }
    }

    public void requestCode(String email) {
        showLoading();
        dataManager.postEasyLogin(email)
                .map(authTokenDTO -> {
                    sharedManager.saveAuthToken(authTokenDTO.getToken());
                    return new RecipientBO(authTokenDTO.getCodeType(), authTokenDTO.getRecipient(), email);
                })
                .subscribe(new Subscriber<RecipientBO>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        processError(((ResponseException) e).getErrorType());
                        hideLoading();
                    }

                    @Override
                    public void onNext(RecipientBO recipientBO) {
                        processSuccess(recipientBO);
                        hideLoading();
                    }
                });
    }

    private void processSuccess(RecipientBO recipientBO) {
        if (getView() != null) {
            getView().onSuccessRequestCode(recipientBO);
        }
    }

    private void showLoading() {
        String message = getAppContext().getString(R.string.loading_in_progress_code);
        if (getView() != null) {
            getView().onShowLoading(message);
        }
    }


}
