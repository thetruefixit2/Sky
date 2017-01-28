package com.dabe.skyapp.view.ui.activities;

import com.dabe.skyapp.interfaces.OnProgressListener;
import com.dabe.skyapp.view.ui.custom.LoadingDialogFragment;

/**
 * Created by Daniil Belevtsev on 28.01.2017 3:59.
 * Project: SkyApp; Skype: pandamoni1
 */

public abstract class PopUpActivity extends RouteActivity implements OnProgressListener {


    @Override
    public void onShowLoading(String title) {
        LoadingDialogFragment loadingDialog = LoadingDialogFragment.newInstance(title);
        loadingDialog.show(getSupportFragmentManager(), LoadingDialogFragment.class.getSimpleName());
    }

    @Override
    public void onHideLoading() {
        LoadingDialogFragment loadingDialog = findAddedFragment(LoadingDialogFragment.class);
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

}
