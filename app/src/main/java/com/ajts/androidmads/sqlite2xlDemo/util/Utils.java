package com.ajts.androidmads.sqlite2xlDemo.util;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by Mushtaq on 14-04-2017.
 */

public class Utils {
    public static void showSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }
}
