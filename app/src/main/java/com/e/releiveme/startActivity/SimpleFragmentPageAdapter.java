package com.e.releiveme.startActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.e.releiveme.Agenda;
import com.e.releiveme.Fait;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new AFaire();
        }
        else if (position == 1) {
            return new Fait();
        }
        else {
            return new Agenda();
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}

