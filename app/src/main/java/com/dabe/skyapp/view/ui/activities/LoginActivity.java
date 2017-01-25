package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;

import com.dabe.skyapp.R;

/**
 * Created by Daniil Belevtsev on 25.01.2017 22:36.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoginActivity extends RouteActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setContainer(R.id.container);

    }
}
