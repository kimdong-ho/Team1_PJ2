package com.example.team1_pj2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Month_Pager_Adapter extends FragmentStateAdapter {
    private static int NUM_ITEMS = 4000*12;

    public Month_Pager_Adapter(@NonNull Fragment frag) {
        super(frag);
    }

    @Override
    public Fragment createFragment(int position) {
        int year = 1 + position/12;
        int month = position%12;
        int day = 1;
        return Month_Calendar_Fragment.newInstance(year,month,day);
    }

    @Override
    public int getItemCount() {
        return NUM_ITEMS;
    }
}
