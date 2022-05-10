package com.example.team1_pj2;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.Calendar;

public class Week_Pager_Adapter extends FragmentStateAdapter {
    private static int ITEM = 3000000;

    public Week_Pager_Adapter(Fragment fragment) {
        super(fragment);
    }

    @Override
    public Fragment createFragment(int position) {
        int year = 0;
        int month = 0;
        int day = 0;
        year = 2022;
        int year_days = 365;

        if (year_days <= 31) {
            day = year_days;
            month = 1;
        }
        else if (year_days <= 59) {
            day = year_days - 31;
            month = 2;
        }
        else if (year_days <= 90) {
            day = year_days - 59;
            month = 3;

        }
        else if (year_days <= 120) {
            day = year_days - 90;
            month = 4;
        }
        else if (year_days <= 151) {
            day = year_days - 120;
            month = 5;
        }
        else if (year_days <= 181) {
            day = year_days - 151;
            month = 6;
        }
        else if (year_days <= 212) {
            day = year_days - 181;
            month = 7;
        }
        else if (year_days <= 243) {
            day = year_days - 212;
            month = 8;
        }
        else if (year_days <= 273) {
            day = year_days - 243;
            month = 9;
        }
        else if (year_days <= 304) {
            day = year_days - 273;
            month = 10;
        }
        else if (year_days <= 334) {
            day = year_days - 304;
            month = 11;
        }
        else if (year_days <= 365){
            day = year_days - 334;
            month = 12;
        }
        Week_Calendar_Fragment week = Week_Calendar_Fragment.newInstance(year, month, day);
        return week;
    }

    public int getItemCount() {
        return ITEM;
    }
}
