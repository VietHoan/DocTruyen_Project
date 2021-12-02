package com.example.doctruyen.fragment;

import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.doctruyen.App;
import com.example.doctruyen.OnActionCallBack;
import com.example.doctruyen.R;
import com.example.doctruyen.adapter.StoryAdapter;
import com.example.doctruyen.model.Story;
import com.example.doctruyen.model.Topic;
import com.example.doctruyen.viewmodel.MainViewModel;

public class M001MainFragment  extends BaseFragment<MainViewModel> implements StoryAdapter.OnItemClick {
        public static final String KEY_SHOW_DETAIL_STORY = "KEY_SHOW_DETAIL_STORY";
        private DrawerLayout drawer;
        private RecyclerView rvStory;


        @Override
        protected void initViews() {
            findViewById(R.id.iv_menu, this);
            rvStory = findViewById(R.id.rv_story);
            rvStory.setLayoutManager(new LinearLayoutManager(getContext()));

            drawer = findViewById(R.id.drawer);
            LinearLayout lnTopic = findViewById(R.id.ln_topic);
            lnTopic.removeAllViews();

            mModel.initData();
            for (Topic item : mModel.getListTopic()) {
                View v = initTopicView(item);
                v.setOnClickListener(v1 -> clickItem(item));
                lnTopic.addView(v);
            }
            initAdapter();
            // test observe by live data

        }



        @Override
        protected Class<MainViewModel> getClassViewModel() {
            return MainViewModel.class;
        }

        @Override
        protected int getLayoutId() {
            return R.layout.m001_main_fragment;
        }


        private void initAdapter() {
            if (mModel.getListStory() == null) return;

            StoryAdapter storyAdapter = new StoryAdapter(mModel.getListStory(), getContext());
            storyAdapter.setOnItemClick(this);
            rvStory.setAdapter(storyAdapter);
        }

        private void clickItem(Topic item) {
            Toast.makeText(getContext(), "Topic: " + item.getTitle(), Toast.LENGTH_SHORT).show();
            //Get list story
            mModel.initListStory(item.getTitle());
            mModel.setTitle(item.getTitle());
            initAdapter();

            drawer.closeDrawers();
        }

        private View initTopicView(Topic item) {
            View view = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_topic, null, false);
            ImageView ivIcon = view.findViewById(R.id.iv_icon);
            TextView tvName = view.findViewById(R.id.tv_name);

            try {
                Glide.with(this).load(BitmapFactory.decodeStream(App.getInstance().getAssets().open(item.getIdName()))).into(ivIcon);
                tvName.setText(item.getTitle());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return view;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.iv_menu) {
                drawer.openDrawer(GravityCompat.START);
            }
        }


    @Override
    public void onItemClick(int storyIdx) {
        callBack.onCallBack(KEY_SHOW_DETAIL_STORY,storyIdx);
    }
}
