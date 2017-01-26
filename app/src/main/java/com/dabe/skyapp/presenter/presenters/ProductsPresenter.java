package com.dabe.skyapp.presenter.presenters;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.view.interfaces.IProductsView;

/**
 * Created by Daniil Belevtsev on 26.01.2017 0:17.
 * Project: SkyApp; Skype: pandamoni1
 */

public class ProductsPresenter extends BasePresenter<IProductsView> {

    public void init(IProductsView view) {
        TheApp.getComponent().inject(this);
        setView(view);
    }
}
