package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.view.interfaces.IProductsMainView;

/**
 * Created by Daniil Belevtsev on 28.01.2017 6:05.
 * Project: SkyApp; Skype: pandamoni1
 */

public class ProductsMainPresenter extends BasePresenter<IProductsMainView> {

    public void init(IProductsMainView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }

    public void clearData() {
        sharedManager.clear();
        if (getView() != null) {
            getView().onSuccessLogOut();
        }
    }

}
