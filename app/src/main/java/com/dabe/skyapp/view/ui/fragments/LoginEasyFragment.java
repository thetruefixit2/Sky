package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.presenter.presenters.LoginEasyPresenter;
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

public class LoginEasyFragment extends BaseLoginFragment implements ILoginView {

    @Inject
    protected LoginEasyPresenter presenter;

    @BindView(R.id.login_email)
    AppCompatEditText etEmail;
    @BindView(R.id.login_sign_button)
    Button btnLogin;
    @BindView(R.id.login_password_mode_button)
    Button btnPasswordMode;

    public static LoginEasyFragment newInstance() {
        Bundle args = new Bundle();
        LoginEasyFragment fragment = new LoginEasyFragment();
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
        View view = inflater.inflate(R.layout.fragment_login_easy, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_sign_button)
    void onLoginClicked() {

    }

    @OnClick(R.id.login_password_mode_button)
    void onLoginModeClick() {
        if (getActivityCallback() != null) {
            getActivityCallback().onOpenHardLoginScreen();
        }
    }
    @OnTextChanged(value = R.id.login_email, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void onLoginTextChanged(Editable etEmail) {
        presenter.validateTexts(etEmail.toString());
    }
    @Override
    public void onLoginButtonEnabled(boolean enabled) {
        btnLogin.setEnabled(enabled);
    }
}
