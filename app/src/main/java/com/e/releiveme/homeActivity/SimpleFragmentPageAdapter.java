package com.e.releiveme.homeActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.e.releiveme.homeActivity.contactFragment.Contact;
import com.e.releiveme.homeActivity.healthFragment.Sante;
import com.e.releiveme.homeActivity.doneTasksFragment.DoneTasksFragment;
import com.e.releiveme.homeActivity.medicalFragment.Medical;
import com.e.releiveme.homeActivity.toDoFragment.ToDoTaskFragment;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    public SimpleFragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new ToDoTaskFragment();
        }
        else if (position == 1) {
            return new DoneTasksFragment();
        }
        else if (position == 2) {
            return new Medical();
        }
        else if (position == 3){
            return new Sante();
        }
        else {
            return new Contact();
        }
    }

    @Override
    public int getCount()
    {
        return 5;
    }
}

