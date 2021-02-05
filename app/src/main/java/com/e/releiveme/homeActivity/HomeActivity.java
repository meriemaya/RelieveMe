package com.e.releiveme.homeActivity;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.wear.ambient.AmbientModeSupport;

import com.e.releiveme.R;

public class HomeActivity extends FragmentActivity implements AmbientModeSupport.AmbientCallbackProvider {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // Find the view pager that will
        // allow the user to swipe
        // between fragments
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);

        // Create an adapter that
        // knows which fragment should
        // be shown on each page
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(getSupportFragmentManager());

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);



    }

    @Override
    public AmbientModeSupport.AmbientCallback getAmbientCallback() {
        return null;
    }
}
