package com.dabe.skyapp.utils;

import android.os.Handler;

import com.dabe.skyapp.app.AppConsts;

/**
 * Created by Daniil Belevtsev on 27.01.2017 21:45.
 * Project: SkyApp; Skype: pandamoni1
 */

public class Timer {

    private OnTimerListener listener;
    private Handler timerHandler;
    private Runnable runnable;
    private long secondsRemains;

    //    @Inject
    public Timer() {
        timerHandler = new Handler();
//        TheApp.getComponent().inject(this);
    }

    public void startTimer(long seconds, OnTimerListener listener) {
        secondsRemains = seconds; // установили сколько работает таймер
        runnable = new Runnable() {
            @Override
            public void run() {
                dec();
                if (getSecondsRemains() > 0) {
                    listener.onTimerTicks(getSecondsRemains());
                    timerHandler.postDelayed(this, AppConsts.ONE_SECOND);
                } else {
                    listener.onStop();
                }

            }
        };
        timerHandler.postDelayed(runnable, AppConsts.ONE_SECOND);
    }

    public void stopTimer() {
        timerHandler.removeCallbacks(runnable);
    }

    private synchronized void dec() {
        secondsRemains--;
    }

    private synchronized long getSecondsRemains() {
        return secondsRemains;
    }

    public interface OnTimerListener {
        void onTimerTicks(long remains);

        void onStop();
    }


}
