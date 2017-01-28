package com.dabe.skyapp.model;

import android.content.SharedPreferences;

import com.dabe.skyapp.TheApp;
import com.dabe.skyapp.app.AppExtras;

import javax.inject.Inject;

/**
 * Created by Daniil Belevtsev on 28.01.2017 3:23.
 * Project: SkyApp; Skype: pandamoni1
 */

public class SharedPreffsManager {

    @Inject
    protected SharedPreferences preferences;

    public SharedPreffsManager() {
        TheApp.getComponent().inject(this);
    }

    public void saveAuthToken(String authToken) {
        preferences.edit().putString(AppExtras.SHARED_AUTH_TOKEN, authToken).apply();
    }

    public String getAuthToken() {
        return preferences.getString(AppExtras.SHARED_AUTH_TOKEN, "");
    }

    public void saveAppToken(String appToken) {
        preferences.edit().putString(AppExtras.SHARED_APP_TOKEN, appToken).apply();
    }

    public String getAppToken() {
        return preferences.getString(AppExtras.SHARED_APP_TOKEN, "");
    }

    public void removeAuthToken() {
        preferences.edit().remove(AppExtras.SHARED_AUTH_TOKEN).apply();
    }

    public void removeAppToken() {
        preferences.edit().remove(AppExtras.SHARED_APP_TOKEN).apply();
    }

    public void clear() {
        preferences.edit().clear().apply();
    }
}
