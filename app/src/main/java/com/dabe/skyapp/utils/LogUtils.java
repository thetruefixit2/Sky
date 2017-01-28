package com.dabe.skyapp.utils;

import android.util.Log;

import com.dabe.skyapp.BuildConfig;


public class LogUtils {
    private static final boolean DEBUG_MODE = BuildConfig.DEBUG;

    public static void logDebug(Object owner, String message) {
        if (DEBUG_MODE) {
            Log.d(owner.getClass().getSimpleName(), message);
        } else {
            //prod-log
        }
    }

    public static void logError(Object owner, String message) {
        if (DEBUG_MODE) {
            Log.e(owner.getClass().getSimpleName(), message);
        } else {
            //prod-log
        }
    }

    public static void logInfo(String message) {
        if (DEBUG_MODE) {
            Log.i(message, message);
        } else {
            //prod-log
        }
    }

    public static void logVerbose(Object owner, String message) {
        if (DEBUG_MODE) {
            Log.v(owner.getClass().getSimpleName(), message);
        } else {
            //prod-log
        }
    }


}
