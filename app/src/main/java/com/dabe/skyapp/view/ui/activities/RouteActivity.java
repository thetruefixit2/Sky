package com.dabe.skyapp.view.ui.activities;


import android.content.Intent;

import com.dabe.skyapp.model.data.enums.CodeTypeEnum;
import com.dabe.skyapp.view.ui.fragments.CodeFragment;
import com.dabe.skyapp.view.ui.fragments.LoginEasyFragment;
import com.dabe.skyapp.view.ui.fragments.LoginHardFragment;
import com.dabe.skyapp.view.ui.fragments.ProductsFragment;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 * Activity that control transactions between screens(fragment switching)
 */

public class RouteActivity extends FragmentActivity {

    protected void showEasyLoginScreen() {
        replaceFragment(LoginEasyFragment.newInstance(), false);
    }

    protected void showHardLoginScreen() {
        replaceFragment(LoginHardFragment.newInstance(), false);
    }

    protected void showCodeScreen(CodeTypeEnum codeType) {
        replaceFragment(CodeFragment.newInstance(codeType), true);
    }

    protected void showProductsScreen() {
        replaceFragment(ProductsFragment.newInstance(), false);
    }

    protected void showMainContainer() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
