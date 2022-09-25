package com.example.opencvdemo.activity;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.example.opencvdemo.R;
import com.example.opencvdemo.base.CaptureImageActivity;
import com.example.opencvdemo.databinding.ActivityBaseBinding;
import com.example.opencvdemo.fragment.MainFragment;

public class MainActivity extends CaptureImageActivity {

    private ActivityBaseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        switchTo(new MainFragment());
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.container;
    }
}