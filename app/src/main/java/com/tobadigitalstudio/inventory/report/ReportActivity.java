package com.tobadigitalstudio.inventory.report;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.tobadigitalstudio.inventory.R;
import com.tobadigitalstudio.inventory.databinding.ActivityReportBinding;
import com.tobadigitalstudio.inventory.report.fragments.AllReportFragment;
import com.tobadigitalstudio.inventory.report.fragments.InComingFragment;
import com.tobadigitalstudio.inventory.report.fragments.OutGoingFragment;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    private ActivityReportBinding binding;

    private TabLayout tab;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_report);

        binding.toolbar.title.setText(getString(R.string.report));
        binding.toolbar.back.setOnClickListener(view -> finish());
        binding.toolbar.confirm.setVisibility(View.GONE);

        tab = binding.tabLayout;
        viewPager = binding.viewPager;
        tab.setupWithViewPager(viewPager);
        SetupViewPager();
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void SetupViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new AllReportFragment(), "All");
        adapter.AddFragment(new InComingFragment(), "Incoming");
        adapter.AddFragment(new OutGoingFragment(), "Outgoing");
        viewPager.setAdapter(adapter);
    }


    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fr = new ArrayList<>();
        private List<String> title = new ArrayList<>();
        public MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public void AddFragment(Fragment fragment, String jd) {
            fr.add(fragment);
            this.title.add(jd);
        }

        @Override
        public Fragment getItem(int position){
            return fr.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return title.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}