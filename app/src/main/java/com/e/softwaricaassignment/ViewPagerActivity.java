package com.e.softwaricaassignment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Fragments.LoginActivity;
import Fragments.RegistrationActivity;
import adapter.ViewPagerAdapter;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout = findViewById(R.id.tabId);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new LoginActivity(), "Login");
        adapter.addFragment(new RegistrationActivity(), "Registration");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
