package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppExtras;
import com.dabe.skyapp.model.data.bo.RecipientBO;
import com.dabe.skyapp.presenter.presenters.CodePresenter;
import com.dabe.skyapp.view.interfaces.ICodeView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:48.
 * Project: SkyApp; Skype: pandamoni1
 */

public class CodeFragment extends BaseLoginFragment implements ICodeView {

    @Inject
    protected CodePresenter presenter;
    @BindView(R.id.login_description)
    TextView tvDescription;
    @BindView(R.id.login_code)
    AppCompatEditText etCode;
    @BindView(R.id.login_sign_button)
    Button btnSignButton;
    @BindView(R.id.login_resend_code_button)
    Button btnResendCode;

    public static CodeFragment newInstance(RecipientBO recipient) {
        Bundle args = new Bundle();
        args.putParcelable(AppExtras.RECIPIENT, recipient);
        CodeFragment fragment = new CodeFragment();
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
        View view = inflater.inflate(R.layout.fragment_login_code, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initDefaultState();
    }

    private void initDefaultState() {
        presenter.initDefaultData(getArguments());
    }

    @OnClick(R.id.login_resend_code_button)
    void onResendCodeClicked() {
        presenter.resendCode();
    }

    @OnClick(R.id.login_sign_button)
    void onSignClicked() {
        presenter.signIn(etCode.getText().toString());
    }

    @OnTextChanged(value = R.id.login_code, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void onCodeChanged(Editable rawCode) {
        presenter.validateData(rawCode.toString());
    }


    @Override
    public void onSignButtonEnabled(boolean enabled) {
        btnSignButton.setEnabled(enabled);
    }

    @Override
    public void onDescriptionTextUpdated(String text) {
        tvDescription.setText(text);
    }

    @Override
    public void onResendButtonTextUpdate(String text) {
        btnResendCode.setText(text);
    }

    @Override
    public void onResendButtonEnableUpdate(boolean enabled) {
        btnResendCode.setEnabled(enabled);
    }

    @Override
    public void onSuccessLogin() {
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
