package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.view.interfaces.ICodeView;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:17.
 * Project: SkyApp; Skype: pandamoni1
 */

public class CodePresenter extends BasePresenter<ICodeView> {

    public void init(ICodeView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }
}
