package com.example.androud_skin_update.skin1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.androud_skin_update.R;
import com.example.androud_skin_update.skin1.fragment.MusicFragment;
import com.example.androud_skin_update.skin1.fragment.RadioFragment;
import com.example.androud_skin_update.skin1.fragment.VideoFragment;
import com.example.androud_skin_update.skin1.widget.MyTabLayout;

import java.util.ArrayList;
import java.util.List;

public class Skin1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //控件的收集在这里完成
        setContentView(R.layout.skin1_activity_main);

        View view = findViewById(R.id.test);

        MyTabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager viewPager = findViewById(R.id.viewPager);
        List<Fragment> list = new ArrayList<>();
        list.add(new MusicFragment());
        list.add(new VideoFragment());
        list.add(new RadioFragment());
        List<String> listTitle = new ArrayList<>();
        listTitle.add("音乐");
        listTitle.add("视频");
        listTitle.add("电台");
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter
                (getSupportFragmentManager(), list, listTitle);
        viewPager.setAdapter(myFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }


    /**
     * 进入换肤
     *
     * @param view
     */
    public void skinSelect(View view) {
        startActivity(new Intent(this, SkinActivity.class));
    }
}
