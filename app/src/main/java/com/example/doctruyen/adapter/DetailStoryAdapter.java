package com.example.doctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.doctruyen.R;
import com.example.doctruyen.model.Story;

import java.util.ArrayList;
import java.util.List;

public class DetailStoryAdapter extends PagerAdapter {
    private List<Story> storyList;
    private Context context;

    public DetailStoryAdapter(List<Story> storyList, Context context){
        this.storyList = storyList;
        context = context;
    }

    @Override
    public int getCount() {
        return storyList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(container.getContext())
                .inflate(R.layout.item_detail_story, container, false);
        TextView tv_title = v.findViewById(R.id.tv_m003_name);
        TextView tv_content = v.findViewById(R.id.tv_content);
        tv_title.setText(storyList.get(position).getName());
        tv_content.setText(storyList.get(position).getContent());
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
