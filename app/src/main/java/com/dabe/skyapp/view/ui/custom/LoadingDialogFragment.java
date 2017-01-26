package com.dabe.skyapp.view.ui.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dabe.skyapp.R;
import com.dabe.skyapp.app.AppExtras;

/**
 * Created by Daniil Belevtsev on 26.01.2017 1:00.
 * Project: SkyApp; Skype: pandamoni1
 */

public class LoadingDialogFragment extends DialogFragment {

    public static LoadingDialogFragment newInstance(String operation) {
        Bundle args = new Bundle();
        args.putString(AppExtras.OPERATION, operation);
        LoadingDialogFragment fragment = new LoadingDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getLayoutInflater(savedInstanceState).inflate(R.layout.view_loading, null, false);
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity())
                .setView(R.layout.view_loading);
        return adb.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
