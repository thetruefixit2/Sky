package com.dabe.skyapp.view.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dabe.skyapp.R;
import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.interfaces.OnProductsCallbackListener;
import com.dabe.skyapp.presenter.presenters.ProductsPresenter;
import com.dabe.skyapp.view.interfaces.IProductsView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:48.
 * Project: SkyApp; Skype: pandamoni1
 */

public class ProductsFragment extends BaseFragment implements IProductsView {

    @Inject
    ProductsPresenter presenter;
    @BindView(R.id.btnLogout)
    Button btnLogout;

    private OnProductsCallbackListener activityCallback;

    public static ProductsFragment newInstance() {
        Bundle args = new Bundle();
        ProductsFragment fragment = new ProductsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        TheApp.getComponent().inject(this);
        super.onCreate(savedInstanceState);
        presenter.init(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductsCallbackListener) {
            activityCallback = (OnProductsCallbackListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProductsCallbackListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btnLogout)
    void onLogoutClicked() {
        if (activityCallback != null) {
            activityCallback.onLogoutRequest();
        }
    }

    @Override
    public void onErrorOccurred(String errorMessage) {
        //
    }

    @Override
    public void onShowLoading(String loadingMessage) {
        //
    }

    @Override
    public void onHideLoading() {
        //
    }


    @Override
    public void onLogOutClicked() {
        if (activityCallback != null) {
            activityCallback.onLogoutRequest();
        }
    }
}
