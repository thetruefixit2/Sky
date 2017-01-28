package com.dabe.skyapp.presenter.presenters;

import android.os.Bundle;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppExtras;
import com.dabe.skyapp.mock.ResponseException;
import com.dabe.skyapp.model.data.bo.RecipientBO;
import com.dabe.skyapp.model.data.dto.response.AppTokenDTO;
import com.dabe.skyapp.model.data.enums.CodeTypeEnum;
import com.dabe.skyapp.utils.LogUtils;
import com.dabe.skyapp.utils.clazz.Timer;
import com.dabe.skyapp.view.interfaces.ICodeView;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:17.
 * Project: SkyApp; Skype: pandamoni1
 */

public class CodePresenter extends BasePresenter<ICodeView> {
    public static final long BLOCK_TIME = 60; // in seconds
    public static final long MAX_RESEND_COUNT = 2;

    @Inject
    protected Timer resendTimer;


    private RecipientBO recipient;

    private long resendCount;

    public void init(ICodeView view) {
        TheApp.getComponent().inject(this);
        setView(view);
        initTitle();
    }

    private void initTitle() {
        String title = getAppContext().getString(R.string.code_in);
        if (getView() != null) {
            getView().onToolbarTitleChanged(title);
        }
    }

    public void initDefaultData(Bundle bundle) {
        if (bundle != null) {
            recipient = (RecipientBO) bundle.getParcelable(AppExtras.RECIPIENT);
            if (recipient != null) {
                updateDescriptionText(recipient.getCodeType(), recipient.getRecipient());
            }
        }
    }

    public void updateData(RecipientBO recipient) {
        if (recipient != null) {
            this.recipient = recipient;
            updateDescriptionText(recipient.getCodeType(), recipient.getRecipient());
        }
    }

    private void updateResendButtonText(long seconds) {
        String formattedText = getFormattedResendText(seconds);
        if (getView() != null) {
            getView().onResendButtonTextUpdate(formattedText);
        }
    }

    private void updateResendEnabledButton(boolean enabled) {
        if (MAX_RESEND_COUNT <= resendCount) {
            enabled = false;
        }
        if (getView() != null) {
            getView().onResendButtonEnableUpdate(enabled);
        }
    }

    private void updateDescriptionText(CodeTypeEnum type, String recipient) {
        if (getView() != null) {
            getView().onDescriptionTextUpdated(getFormattedDescription(type, recipient));
        }
    }

    public void validateData(String code) {
        boolean validateResult = false;
        if (!code.isEmpty()) {
            validateResult = true;
            //may be some other actions
        }
        if (getView() != null) {
            getView().onSignButtonEnabled(validateResult);
        }
    }

    public void signIn(String code) {
        showLoading();
        String authToken = sharedManager.getAuthToken();
        dataManager.postVerifyCode(code, authToken)
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
                        processSignInSuccess();
                        hideLoading();
                    }
                });
    }

    public void resendCode() {
        resendCount++; // ограниченное число попыток
        startTimer(BLOCK_TIME); // запустили таймер
        updateResendEnabledButton(false); //отключили кнопку
        String email = recipient.getRecipientLogin();
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
                        processResendSuccess(recipientBO);
                        hideLoading();
                    }
                });
    }


    private void processResendSuccess(RecipientBO recipientBO) {
        updateData(recipientBO);
    }

    private void processSignInSuccess() {
        sharedManager.removeAuthToken();
        if (getView() != null) {
            getView().onSuccessLogin();
        }
    }

    private void showLoading() {
        String message = getAppContext().getString(R.string.loading_in_progress_login);
        if (getView() != null) {
            getView().onShowLoading(message);
        }
    }

    private void startTimer(long timeLength) {
        resendTimer.startTimer(timeLength, new Timer.OnTimerListener() {
            @Override
            public void onTimerTicks(long secondsRemains) {
                updateResendButtonText(secondsRemains);
            }

            @Override
            public void onStop() {
                updateResendButtonText(0);
                updateResendEnabledButton(true);
            }
        });
    }


    private String getFormattedDescription(CodeTypeEnum type, String recipient) {
        String result;
        switch (type) {
            case EMAIL:
                result = String.format(getAppContext().getString(R.string.code_sent_email), recipient);
                break;
            case PHONE:
                result = String.format(getAppContext().getString(R.string.code_sent_phone), recipient);
                break;
            default:
                result = getAppContext().getString(R.string.code_sent_phone);
        }

        return result;
    }

    private String getFormattedResendText(long seconds) {
        String timeRemains = "";
        String resendText = "";
        try {
            timeRemains = seconds > 0 ? String.format(getAppContext().getString(R.string.code_seconds_remain), seconds) : "";
            resendText = getAppContext().getString(R.string.code_resend);
        } catch (NullPointerException exception) {
            LogUtils.logError(this, exception.getMessage());
        }

        return resendText.concat(timeRemains);
    }

}
