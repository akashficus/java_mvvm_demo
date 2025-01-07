package com.rf.javamvvmdemo.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.rf.javamvvmdemo.R;

public class Utility {

    public static Dialog showCommonProgressDialog(Context context) {
        // Inflate the custom progress bar layout
        View views = LayoutInflater.from(context).inflate(R.layout.item_progress_bar, null);

        // Create and configure the dialog
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        }
        dialog.setContentView(views);
        dialog.setCancelable(false);

        return dialog;
    }
}
