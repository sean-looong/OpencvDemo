package com.example.opencvdemo.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.opencvdemo.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class BaseActivity extends AppCompatActivity {

    private Fragment currentFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Android 6.0 以上设置为透明状态栏，状态栏文字为浅黑色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            );
        }
        trackFragmentBackStack();
    }

    /**
     * 弹出提示框
     */
    public void showMsg(String message) {
        Snackbar snack = Snackbar.make(getWindow().getDecorView(), message, BaseTransientBottomBar.LENGTH_SHORT);
        View view = snack.getView();
        FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        snack.show();
    }

    /**
     * 设置fragment (直接替换当前的fragment)
     * @param target 显示的fragment
     */
    public void switchTo(Fragment target) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(getFragmentContainerId(), target, target.getClass().getCanonicalName());
        ft.setCustomAnimations(0, 0, 0, 0);
        ft.commit();
        currentFragment = target;
    }

    /**
     * 更新当前fragment (将新的fragment加入栈顶)
     * @param next 显示的fragment
     */
    public void push(Fragment next) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left,
                R.anim.slide_in_left, R.anim.slide_out_right);
        ft.add(getFragmentContainerId(), next, next.getClass().getCanonicalName()).hide(currentFragment)
                .addToBackStack(currentFragment.getClass().getCanonicalName());
        ft.commit();
        currentFragment = next;
    }

    /**
     * 获取当前fragment类名
     * @return 当前fragment类名
     */
    public String getCurrentFragmentTag() {
        return currentFragment.getClass().getCanonicalName();
    }

    protected int getFragmentContainerId() {
        throw new AndroidRuntimeException("Override this method, return fragment container layout resource id please.");
    }

    /**
     * 当fragment弹栈的时候，更新当前fragment记录
     */
    private void trackFragmentBackStack() {
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(getFragmentContainerId());
                if (fragment != null) {
                    currentFragment = fragment;
                }
            }
        });
    }
}
