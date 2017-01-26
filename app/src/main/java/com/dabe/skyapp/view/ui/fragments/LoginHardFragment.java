package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.presenter.presenters.LoginHardPresenter;
import com.dabe.skyapp.view.interfaces.ILoginView;

import javax.inject.Inject;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:47.
 * Project: SkyApp; Skype: pandamoni1
 * Note: Сделал LoginHardFragment и LoginEasyFragment, так как думаю, что лучше будет и выполним SRP
 */

public class LoginHardFragment extends BaseLoginFragment implements ILoginView{

    @Inject
    protected LoginHardPresenter presenter;

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

}
