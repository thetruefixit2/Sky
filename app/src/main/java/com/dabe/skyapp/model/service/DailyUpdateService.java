package com.dabe.skyapp.model.service;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Daniil Belevtsev on 28.01.2017 15:09.
 * Project: SkyApp; Skype: pandamoni1
 */

public class DailyUpdateService extends IntentService {
    public static final String TAG = "DailyUpdateService";
    public static final int SERVICE_ID = 300;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */

    public DailyUpdateService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
