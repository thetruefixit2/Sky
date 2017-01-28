package com.dabe.skyapp.di;

import com.dabe.skyapp.di.modules.AppModule;
import com.dabe.skyapp.di.modules.ModelModule;
import com.dabe.skyapp.di.modules.PresenterModule;
import com.dabe.skyapp.di.modules.ViewModule;
import com.dabe.skyapp.model.DataManager;
import com.dabe.skyapp.model.SharedPreffsManager;
import com.dabe.skyapp.presenter.presenters.CodePresenter;
import com.dabe.skyapp.presenter.presenters.LoginEasyPresenter;
import com.dabe.skyapp.presenter.presenters.LoginHardPresenter;
import com.dabe.skyapp.presenter.presenters.LoginMainPresenter;
import com.dabe.skyapp.presenter.presenters.ProductsMainPresenter;
import com.dabe.skyapp.presenter.presenters.ProductsPresenter;
import com.dabe.skyapp.view.ui.activities.LoginActivity;
import com.dabe.skyapp.view.ui.activities.ProductsActivity;
import com.dabe.skyapp.view.ui.fragments.CodeFragment;
import com.dabe.skyapp.view.ui.fragments.LoginEasyFragment;
import com.dabe.skyapp.view.ui.fragments.LoginHardFragment;
import com.dabe.skyapp.view.ui.fragments.ProductsFragment;

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

    void inject(SharedPreffsManager sharedManager);
//    void inject(Timer timer);

    ///////////////////////////////////////////////////////////////////////////
    // VIEW
    ///////////////////////////////////////////////////////////////////////////
    void inject(ProductsActivity activity);

    void inject(LoginActivity activity);
    void inject(LoginEasyFragment fragment);
    void inject(LoginHardFragment fragment);
    void inject(CodeFragment fragment);
    void inject(ProductsFragment fragment);
    ///////////////////////////////////////////////////////////////////////////
    // PRESENTER
    ///////////////////////////////////////////////////////////////////////////
    void inject(LoginEasyPresenter presenter);
    void inject(LoginHardPresenter presenter);
    void inject(CodePresenter presenter);
    void inject(ProductsPresenter presenter);

    void inject(ProductsMainPresenter presenter);

    void inject(LoginMainPresenter presenter);

}
