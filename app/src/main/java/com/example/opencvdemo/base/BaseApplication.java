package com.example.opencvdemo.base;

import android.app.Application;

import com.example.opencvdemo.utils.LogUtil;

import org.opencv.android.OpenCVLoader;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        iniOpenCV();
    }

    /**
     * 加载OpenCV库
     */
    private void iniOpenCV() {
        if (OpenCVLoader.initDebug()) {
            LogUtil.info(LogUtil.APP_TAG, "OpenCV Libraries Loaded...");
        } else {
            LogUtil.error(LogUtil.APP_TAG, "Could not load OpenCV Libraries!");
        }
    }
}
