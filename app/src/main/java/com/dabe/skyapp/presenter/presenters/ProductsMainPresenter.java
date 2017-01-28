package com.dabe.skyapp.presenter.presenters;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppExtras;
import com.dabe.skyapp.model.service.DailyUpdateService;
import com.dabe.skyapp.view.interfaces.IProductsMainView;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static android.content.Context.ALARM_SERVICE;

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
        cancelDailyUpdate();
        if (getView() != null) {
            getView().onSuccessLogOut();
        }
    }

    public void startDailyUpdate() {
        Calendar cal = Calendar.getInstance();
        AlarmManager am = (AlarmManager) getAppContext().getSystemService(ALARM_SERVICE);
        long interval = TimeUnit.DAYS.toMillis(1); // 1day in milliseconds
        Intent serviceIntent = new Intent(getAppContext(), DailyUpdateService.class);
        serviceIntent.putExtra(AppExtras.TOKEN, sharedManager.getAppToken());
        PendingIntent servicePendingIntent =
                PendingIntent.getService(getAppContext(),
                        DailyUpdateService.SERVICE_ID, // integer constant used to identify the service
                        serviceIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT);  // FLAG to avoid creating a second service if there's already one running
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), servicePendingIntent);
        } else {
            am.setRepeating(
                    AlarmManager.RTC_WAKEUP,//type of alarm. This one will wake up the device when it goes off, but there are others, check the docs
                    cal.getTimeInMillis(),
                    interval,
                    servicePendingIntent
            );
        }
    }

    private void cancelDailyUpdate() {
        Intent intent = new Intent(getAppContext(), DailyUpdateService.class);
        PendingIntent pendingIntent = PendingIntent.getService(getAppContext(), DailyUpdateService.SERVICE_ID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getAppContext().getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
    }

}
