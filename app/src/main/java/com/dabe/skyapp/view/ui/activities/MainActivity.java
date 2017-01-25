package com.dabe.skyapp.view.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dabe.skyapp.R;

/**
 * Created by Daniil Belevtsev on 25.01.2017 23:27.
 * Project: SkyApp; Skype: pandamoni1
 */

public class MainActivity extends RouteActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        setContainer(R.id.container);
    }
}
