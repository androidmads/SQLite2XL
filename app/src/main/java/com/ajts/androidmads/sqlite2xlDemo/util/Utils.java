package com.ajts.androidmads.sqlite2xlDemo.util;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

/**
 * Created by Mushtaq on 14-04-2017.
 */

public class Utils {
    public static void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
