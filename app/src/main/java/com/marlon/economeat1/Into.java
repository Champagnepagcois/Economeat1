package com.marlon.economeat1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.marlon.economeat1.fragments.CenterFragment;
import com.marlon.economeat1.fragments.HomeFragment;
import com.marlon.economeat1.fragments.ProfileFragment;
import com.marlon.economeat1.fragments.SearchFragment;

public class Into extends AppCompatActivity {

    private HomeFragment homeFrangment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;
    private CenterFragment centerFragment;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);

        homeFrangment = new HomeFragment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();
        centerFragment = new CenterFragment();

        setFragment(homeFrangment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(homeFrangment);
                        return true;

                    case R.id.nav_center :
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(centerFragment);
                        return true;

                    case R.id.nav_profile :
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(profileFragment);
                        return true;

                    case R.id.nav_search :
                        mMainNav.setItemBackgroundResource(R.color.graylight);
                        setFragment(searchFragment);
                        return true;

                    default:
                        return false;
                }
            }


        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }


}

