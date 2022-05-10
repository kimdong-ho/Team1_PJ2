package com.example.team1_pj2;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;
import java.util.TimeZone;

public class Month_View_Fragment extends Fragment {

    private static final String Param1 = "YEAR";
    private static final String Param2 = "MONTH";
    private static final String Param3 = "DAY";

    private int mYear;
    private int mMonth;
    private int mDay;

    private int thisPosition;

    public Month_View_Fragment() {
    }

    public static Month_View_Fragment newInstance(int param1, int param2, int param3) {
        Month_View_Fragment fragment = new Month_View_Fragment();
        Bundle args = new Bundle();
        args.putInt(Param1, param1);
        args.putInt(Param2, param2);
        args.putInt(Param3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mYear = getArguments().getInt(Param1);
            mMonth = getArguments().getInt(Param2);
            mDay = getArguments().getInt(Param3);
        }
    }

    ViewPager2 monthViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month_view, container, false);
        monthViewPager = view.findViewById(R.id.monthViewPager);

        Month_Pager_Adapter monthPagerAdapter = new Month_Pager_Adapter(this);
        monthViewPager.setAdapter(monthPagerAdapter);


        Calendar cal = Calendar.getInstance();
        int thisYear = cal.get(Calendar.YEAR);
        int thisMonth = cal.get(Calendar.MONTH);

        int initPosition = (thisYear-1) * 12 + thisMonth;

        monthViewPager.setCurrentItem(initPosition);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(thisYear + "년" + (thisMonth + 1) + "월");

        monthViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                mYear = position / 12 + 1;
                mMonth = position % 12 + 1;
                actionBar.setTitle(mYear + "년" + mMonth + "월");
            }
        });

        return view;
    }

}