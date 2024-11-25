package com.example.test_btl;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new SourceFragment(), "Nguồn Tiền");
        adapter.addFragment(new IncomeFragment(), "Khoản Thu");
        adapter.addFragment(new ExpenseFragment(), "Khoản Chi");
        adapter.addFragment(new StatisticsFragment(), "Thống Kê");

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(adapter.getPageTitle(position));

            if (position == 0) {
                tab.setIcon(R.drawable.ic_money);
            } else if (position == 1) {
                tab.setIcon(R.drawable.ic_income);
            } else if (position == 2) {
                tab.setIcon(R.drawable.ic_expense);
            } else if (position == 3) {
                tab.setIcon(R.drawable.ic_stats);
            }
        }).attach();

    }
}