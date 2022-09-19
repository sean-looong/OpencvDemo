package com.example.opencvdemo.utils;

import android.util.Log;

public class LogUtil {

    public static final String APP_TAG = "OpenCVTag";

    public static void debug(final String tag, final String message) {
        Log.d(tag, message);
    }

    public static void info(final String tag, final String message) {
        Log.i(tag, message);
    }

    public static void warning(final String tag, final String message) {
        Log.w(tag, message);
    }

    public static void error(final String tag, final String message) {
        Log.e(tag, message);
    }
}
