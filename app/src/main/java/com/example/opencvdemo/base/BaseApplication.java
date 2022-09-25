package com.example.opencvdemo.base;

import android.app.Application;
import android.content.Context;

import com.example.opencvdemo.utils.LogUtil;

import org.opencv.android.OpenCVLoader;

import java.util.Objects;

public class BaseApplication extends Application {

    private static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        iniOpenCV();
    }

    /**
     * @return 获取BaseApplication上下文
     */
    public static Context getAppContext() {
        return context;
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
