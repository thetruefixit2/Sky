package com.dabe.skyapp.di;

import com.dabe.skyapp.di.modules.AppModule;
import com.dabe.skyapp.di.modules.ModelModule;
import com.dabe.skyapp.di.modules.PresenterModule;
import com.dabe.skyapp.di.modules.ViewModule;
import com.dabe.skyapp.model.DataManager;
import com.dabe.skyapp.presenter.MainPresenter;
import com.dabe.skyapp.view.ui.activities.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

@Singleton
@Component(modules = {AppModule.class, ModelModule.class, ViewModule.class, PresenterModule.class})
public interface BaseComponent {

    ///////////////////////////////////////////////////////////////////////////
    // MODEL
    ///////////////////////////////////////////////////////////////////////////
    void inject(DataManager dataManager);

    ///////////////////////////////////////////////////////////////////////////
    // VIEW
    ///////////////////////////////////////////////////////////////////////////
    void inject(LoginActivity activity);

    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////
    void inject(MainPresenter presenter);
}
