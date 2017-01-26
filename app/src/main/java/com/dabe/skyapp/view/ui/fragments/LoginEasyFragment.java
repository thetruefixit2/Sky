package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.presenter.presenters.LoginEasyPresenter;
import com.dabe.skyapp.view.interfaces.ILoginView;

import javax.inject.Inject;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:47.
 * Project: SkyApp; Skype: pandamoni1
 * Note: Сделал LoginHardFragment и LoginEasyFragment, так как думаю, что лучше будет и выполним SRP
 */

public class LoginEasyFragment extends BaseLoginFragment implements ILoginView {

    @Inject
    protected LoginEasyPresenter presenter;

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
        return view;
    }
}
