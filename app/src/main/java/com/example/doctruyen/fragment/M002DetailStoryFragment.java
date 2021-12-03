package com.example.doctruyen.fragment;

import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.doctruyen.OnActionCallBack;
import com.example.doctruyen.R;
import com.example.doctruyen.adapter.DetailStoryAdapter;
import com.example.doctruyen.viewmodel.MainViewModel;

public class M002DetailStoryFragment extends BaseFragment<MainViewModel>  {
    private int storyIdx;

    @Override
    protected void initViews() {
        ViewPager viewPager = findViewById(R.id.vp_story);
        viewPager.setAdapter(new DetailStoryAdapter(mModel.getListStory(),mContext));
        viewPager.setCurrentItem(storyIdx);
        TextView tv_Topic = findViewById(R.id.tv_topic);
        TextView tv_Index = findViewById(R.id.tv_index);
        tv_Topic.setText(mModel.getTitle());
        tv_Index.setText(String.valueOf(storyIdx+1) + "/" + String.valueOf(mModel.getListStory().size()));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_Index.setText(String.valueOf(position+1) + "/" + String.valueOf(mModel.getListStory().size()));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected Class<MainViewModel> getClassViewModel() {
        return MainViewModel.class;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.m002_detail_story_fragment;
    }

    public void setStoryIdx(int storyIdx) {
        this.storyIdx = storyIdx;
    }
}
