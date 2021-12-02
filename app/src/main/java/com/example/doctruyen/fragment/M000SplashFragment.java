package com.example.doctruyen.fragment;

import android.os.Handler;

import com.example.doctruyen.OnActionCallBack;
import com.example.doctruyen.R;
import com.example.doctruyen.viewmodel.SplashViewModel;

public class M000SplashFragment extends BaseFragment<SplashViewModel> {
    public static final String KEY_SHOW_MAIN_FRAGMENT = "KEY_SHOW_MAIN_FRAGMENT";


    @Override
    protected void initViews() {
        new Handler().postDelayed(this::gotoMainFragment, 2000);
    }

    @Override
    protected Class<SplashViewModel> getClassViewModel() {
        return SplashViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.m000_splash_fragment;
    }

    private void gotoMainFragment() {
        callBack.onCallBack(KEY_SHOW_MAIN_FRAGMENT, null);
    }
}
