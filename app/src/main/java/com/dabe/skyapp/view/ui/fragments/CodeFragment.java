package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppExtras;
import com.dabe.skyapp.model.data.enums.CodeTypeEnum;
import com.dabe.skyapp.presenter.presenters.CodePresenter;
import com.dabe.skyapp.view.interfaces.ICodeView;

import javax.inject.Inject;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:48.
 * Project: SkyApp; Skype: pandamoni1
 */

public class CodeFragment extends BaseLoginFragment implements ICodeView {

    @Inject
    protected CodePresenter presenter;

    public static CodeFragment newInstance(CodeTypeEnum codeType) {
        Bundle args = new Bundle();
        args.putSerializable(AppExtras.CODE_TYPE, codeType);
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

}
