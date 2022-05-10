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

    private static final String Param1 = "YEAR"; // 키값
    private static final String Param2 = "MONTH"; // 키값
    private static final String Param3 = "DAY"; // 키값

    private int mYear;
    private int mMonth;
    private int mDay;

    private int thisPosition;

    public Month_View_Fragment() {
    }

    public static Month_View_Fragment newInstance(int param1, int param2, int param3) { // 강의자료 참고
        Month_View_Fragment fragment = new Month_View_Fragment();
        Bundle args = new Bundle();
        args.putInt(Param1, param1);
        args.putInt(Param2, param2);
        args.putInt(Param3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { // 강의자료 참고
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
        View view = inflater.inflate(R.layout.month_view, container, false); // month_view xml과 연결
        monthViewPager = view.findViewById(R.id.monthViewPager);

        Month_Pager_Adapter monthPagerAdapter = new Month_Pager_Adapter(this); // Month_Pager_Adapter 객체 생성
        monthViewPager.setAdapter(monthPagerAdapter);


        Calendar cal = Calendar.getInstance();
        int thisYear = cal.get(Calendar.YEAR); // 현재 년 가져오기
        int thisMonth = cal.get(Calendar.MONTH); // 현재 달 가져오기

        int initPosition = (thisYear-1) * 12 + thisMonth;

        monthViewPager.setCurrentItem(initPosition);

        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar(); // 액션바 년 월 표시
        actionBar.setTitle(thisYear + "년" + (thisMonth + 1) + "월");

        monthViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) { // 페이지 넘길때 메소드
                mYear = position / 12 + 1; // 12달이 넘어가면 년 1증가
                mMonth = position % 12 + 1; // 넘어갈때마다 1증가
                actionBar.setTitle(mYear + "년" + mMonth + "월"); // 액션바도 변화
            }
        });
        return view;
    }

}