package com.example.namavahiringtest.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.namavahiringtest.fragment.MainFragment;
import com.example.namavahiringtest.R;
import com.example.namavahiringtest.repository.Repository;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.main_activity_view_pager);
        mTabLayout = findViewById(R.id.main_activity_tab_layout);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return MainFragment.newInstance();
            }

            @Override
            public int getCount() {
                return Repository.getInstance().getTitlesLists().size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {

                return Repository.getInstance().getTitlesLists().get(position);
            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
