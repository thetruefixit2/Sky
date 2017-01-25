package com.dabe.skyapp.presenter;


import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.view.interfaces.IMainView;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public class MainPresenter extends BasePresenter<IMainView> {

    public void init(IMainView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }
}
