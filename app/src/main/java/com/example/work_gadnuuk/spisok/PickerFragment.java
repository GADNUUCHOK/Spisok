package com.example.work_gadnuuk.spisok;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

public class PickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        /**View v = LayoutInflater.from(getActivity())
                .inflate(R.layout., null);*/

        return new AlertDialog.Builder(getActivity())
                //.setView(v)
                .setTitle(R.string.picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
