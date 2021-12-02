package com.example.doctruyen.act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.doctruyen.OnActionCallBack;
import com.example.doctruyen.R;
import com.example.doctruyen.fragment.M000SplashFragment;
import com.example.doctruyen.fragment.M001MainFragment;
import com.example.doctruyen.fragment.M002DetailStoryFragment;
import com.example.doctruyen.viewmodel.MainViewModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends BaseAct<MainViewModel> implements OnActionCallBack {

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        M000SplashFragment splashFragment = new M000SplashFragment();
        splashFragment.setCallBack(this);
        // chi co activity ms co the show fragment
        showFragment(R.id.container_view, splashFragment, false);
    }

    @Override
    public void onCallBack(String key, Object listObject) {
        switch (key) {
            case M000SplashFragment.KEY_SHOW_MAIN_FRAGMENT:
                M001MainFragment mainFragment = new M001MainFragment();
                mainFragment.setCallBack(this);
                showFragment(R.id.container_view, mainFragment, false);
                break;
            case M001MainFragment.KEY_SHOW_DETAIL_STORY:
                M002DetailStoryFragment detailStoryFragment = new M002DetailStoryFragment();
                detailStoryFragment.setCallBack(this);
                if (listObject!= null){
                    detailStoryFragment.setStoryIdx((int) listObject);
                }
                showFragment(R.id.container_view, detailStoryFragment, true);
                break;
        }
    }
}