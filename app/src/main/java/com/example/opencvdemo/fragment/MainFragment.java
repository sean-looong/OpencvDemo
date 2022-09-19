package com.example.opencvdemo.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.opencvdemo.R;
import com.example.opencvdemo.base.BaseFragment;
import com.example.opencvdemo.databinding.FragmentMainBinding;

import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainFragment extends BaseFragment {

    FragmentMainBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
                Mat src = new Mat();
                Mat dst = new Mat();
                Utils.bitmapToMat(bitmap, src);
                Imgproc.cvtColor(src, dst, Imgproc.COLOR_BGRA2GRAY);
                Utils.matToBitmap(dst, bitmap);
                binding.imgView.setImageBitmap(bitmap);
                src.release();
                dst.release();
            }
        });
    }
}
