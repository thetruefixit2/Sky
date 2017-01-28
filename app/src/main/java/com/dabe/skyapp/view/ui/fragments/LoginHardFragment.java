package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.model.data.bo.RecipientBO;
import com.dabe.skyapp.presenter.presenters.LoginHardPresenter;
import com.dabe.skyapp.view.interfaces.ILoginView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:47.
 * Project: SkyApp; Skype: pandamoni1
 * Note: Сделал LoginHardFragment и LoginEasyFragment, так как думаю, что лучше будет и выполним SRP
 */

public class LoginHardFragment extends BaseLoginFragment implements ILoginView {

    @Inject
    protected LoginHardPresenter presenter;

    @BindView(R.id.login_email)
    AppCompatEditText etEmail;
    @BindView(R.id.login_password)
    AppCompatEditText etPassword;
    @BindView(R.id.login_sign_button)
    Button btnLogin;
    @BindView(R.id.login_password_mode_button)
    Button btnPasswordMode;

    public static LoginHardFragment newInstance() {
        Bundle args = new Bundle();
        LoginHardFragment fragment = new LoginHardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_hard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_sign_button)
    void onLoginClicked() {
        presenter.login(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @OnClick(R.id.login_password_mode_button)
    void onLoginModeClick() {
        if (getActivityCallback() != null) {
            getActivityCallback().onOpenEasyLoginScreen();
        }
    }

    @OnTextChanged(value = {R.id.login_email, R.id.login_password},
            callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void onLoginTextChanged() {
        presenter.validateData(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void onSignButtonEnabled(boolean enabled) {
        btnLogin.setEnabled(enabled);
    }

    @Override
    public void onSuccessRequestCode(RecipientBO recipient) {
        //для этого типа нет.
    }

    @Override
    public void onSuccessSignIn() {
        if (getActivityCallback() != null) {
            getActivityCallback().onSuccessLogin();
        }
    }

    @Override
    public void onToolbarTitleChanged(String title) {
        if (getActivityCallback() != null) {
            getActivityCallback().onToolbarTitleChanged(title);
        }
    }

}
