package com.example.opencvdemo.base;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    /**32
     * 弹出提示框
     */
    public void showMsg(String message) {
        ((BaseActivity)requireActivity()).showMsg(message);
    }

    /**
     * 设置fragment (直接替换当前的fragment)
     * @param target 显示的fragment
     */
    public void switchTo(Fragment target) {
        ((BaseActivity)requireActivity()).switchTo(target);
    }

    /**
     * 更新当前fragment (将新的fragment加入栈顶)
     * @param next 显示的fragment
     */
    public void push(Fragment next) {
        ((BaseActivity)requireActivity()).push(next);
    }
}
