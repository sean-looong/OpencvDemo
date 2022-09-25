package com.example.opencvdemo.base;

import android.content.Intent;
import android.net.Uri;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;

import com.example.opencvdemo.BuildConfig;
import com.example.opencvdemo.utils.DateUtil;

import java.io.File;

public abstract class CaptureImageActivity extends BaseActivity {
    private Uri photoUri = null;

    private final ActivityResultLauncher<Uri> captureImgLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.TakePicture(), result -> {
                        if (result) {
                            // do something
                        }
                    });
    private final ActivityResultLauncher<String> pickupLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.GetContent(), result -> {
                        if (result != null) {

                        }
                    });

    /**
     * 调用系统相机拍照
     */
    public void captureImage() {
        File imageDirectory = new File(getExternalFilesDir(""), "ext_images");
        if (!imageDirectory.exists()) {
            if (!imageDirectory.mkdirs()) {
                showMsg("创建相册目录失败");
                return;
            }
        }
        File imageFile = new File(imageDirectory, DateUtil.getCurrentDate() + ".png");
        photoUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".files", imageFile);
        captureImgLauncher.launch(photoUri);
    }

    /**
     * 选取图片文件
     */
    public void pickupImage() {
        pickupLauncher.launch("image/*");
    }
}
