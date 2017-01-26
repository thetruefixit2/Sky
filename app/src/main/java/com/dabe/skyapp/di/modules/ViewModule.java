package com.dabe.skyapp.di.modules;

import com.dabe.skyapp.presenter.presenters.CodePresenter;
import com.dabe.skyapp.presenter.presenters.LoginEasyPresenter;
import com.dabe.skyapp.presenter.presenters.LoginHardPresenter;
import com.dabe.skyapp.presenter.presenters.ProductsPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

@Module
public class ViewModule {
    @Provides
    CodePresenter provideCodePresenter() {
        return new CodePresenter();
    }

    @Provides
    LoginEasyPresenter provideLoginEasyPresenter() {
        return new LoginEasyPresenter();
    }

    @Provides
    LoginHardPresenter provideLoginHardPresenter() {
        return new LoginHardPresenter();
    }

    @Provides
    ProductsPresenter provideProductsPresenter() {
        return new ProductsPresenter();
    }
}
