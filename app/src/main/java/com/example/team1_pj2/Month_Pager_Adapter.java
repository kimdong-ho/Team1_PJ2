package com.example.team1_pj2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Month_Pager_Adapter extends FragmentStateAdapter {
    private static int NUM_ITEMS = 4000*12; // 아이템 생성

    public Month_Pager_Adapter(@NonNull Fragment frag) {
        super(frag);
    }

    @Override
    public Fragment createFragment(int position) {
        int year = 1 + position/12; // 12번 넘어갈때 마다 1증가
        int month = position%12; // 12달
        int day = 1;
        return Month_Calendar_Fragment.newInstance(year,month,day);
    }

    @Override
    public int getItemCount() {
        return NUM_ITEMS;
    } // 아이템 반환
}
