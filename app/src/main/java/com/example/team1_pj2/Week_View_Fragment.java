package com.example.team1_pj2;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Calendar;


class Week_View_Fragment extends Fragment { // 키값

    private static final String ARG_PARAM1 = "year";
    private static final String ARG_PARAM2 = "month";
    private static final String ARG_PARAM3 = "DAY";

    private int mYear;
    private int mMonth;
    private int mDay;

    public Week_View_Fragment() {

    }


    public static Week_View_Fragment newInstance(int param1, int param2, int param3) { // 강의자료랑 동일
        Week_View_Fragment fragment = new Week_View_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { // 강의자료 참고 // 초기화 하는 코드
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mYear = getArguments().getInt(ARG_PARAM1);
            mMonth = getArguments().getInt(ARG_PARAM2);
            mDay = getArguments().getInt(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.week_view, container, false);
        ViewPager2 weekVP2 = view.findViewById(R.id.weekVPager);
        Week_Pager_Adapter adapter = new Week_Pager_Adapter(this);
        weekVP2.setAdapter(adapter);

        int totaldays = calDays(mYear,mMonth+1,mDay);
        int initPosition = totaldays/7;

        Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR);
        mMonth = cal.get(Calendar.MONTH);
        mDay = cal.get(Calendar.DAY_OF_MONTH);

        weekVP2.setCurrentItem(initPosition,false);

        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar(); // 액션바 사용하기
        ab.setTitle(mYear+"년"+(mMonth+1)+"월"); // 현재 년월 표시

        weekVP2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // 필요한 메소드만 재정의 할 수 있게 하는 코드

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int year = 0;
                int month = 0;
                int day = 0;
                year = 2022;
                int year_days = 365;

                int totalDays = 7;

                mYear = cal.get(Calendar.YEAR);

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
                ab.setTitle(mYear +"년"+ mMonth +"월");
            }
        });

        return view;
    }

    public int calDays(int year, int month, int day) {
        int total_days= 365;
        return total_days;
    }
}