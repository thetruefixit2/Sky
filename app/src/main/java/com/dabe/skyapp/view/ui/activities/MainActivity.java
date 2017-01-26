package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dabe.skyapp.R;
import com.dabe.skyapp.interfaces.OnProductsCallbackListener;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:27.
 * Project: SkyApp; Skype: pandamoni1
 */

public class MainActivity extends RouteActivity implements OnProductsCallbackListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setContainer(R.id.container);
        showProductsScreen();
    }


    @Override
    public void onShowLoading(String title) {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    public void onErrorOccurred(String errorMessage) {

    }
}
