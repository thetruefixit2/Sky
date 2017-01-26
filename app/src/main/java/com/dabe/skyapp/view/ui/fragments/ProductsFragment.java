package com.dabe.skyapp.view.ui.fragments;

import android.os.Bundle;

import com.dabe.skyapp.view.interfaces.IProductsView;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:48.
 * Project: SkyApp; Skype: pandamoni1
 */

public class ProductsFragment extends BaseFragment implements IProductsView{

    public static ProductsFragment newInstance() {
        Bundle args = new Bundle();
        ProductsFragment fragment = new ProductsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public void showLoading(String loadingMessage) {

    }

    @Override
    public void hideLoading() {

    }
}
