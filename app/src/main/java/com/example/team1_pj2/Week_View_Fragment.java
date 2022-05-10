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
                int allday = position * 7;
                int year_days = allday % 365;

                mYear = cal.get(Calendar.YEAR);

                if (year_days <= 31) { // 1월
                    mDay = year_days;
                    mMonth = 1;
                }
                else if (year_days <= 59) { // 2월
                    mDay = year_days - 31;
                    mMonth = 2;
                }
                else if (year_days <= 90) { // 3월
                    mDay = year_days - 59;
                    mMonth = 3;

                }
                else if (year_days <= 120) { // 4월
                    mDay = year_days - 90;
                    mMonth = 4;
                }
                else if (year_days <= 151) { // 5월
                    mDay = year_days - 120;
                    mMonth = 5;
                }
                else if (year_days <= 181) { // 6월
                    mDay = year_days - 151;
                    mMonth = 6;
                }
                else if (year_days <= 212) { // 7월
                    mDay = year_days - 181;
                    mMonth = 7;
                }
                else if (year_days <= 243) { // 8월
                    mDay = year_days - 212; 
                    mMonth = 8;
                }
                else if (year_days <= 273) { // 9월
                    mDay = year_days - 243;
                    mMonth = 9;
                }
                else if (year_days <= 304) { // 10월
                    mDay = year_days - 273;
                    mMonth = 10;
                }
                else if (year_days <= 334) { // 11월
                    mDay = year_days - 304;
                    mMonth = 11;
                }
                else if (year_days <= 365){ // 12월
                    mDay = year_days - 334;
                    mMonth = 12;
                }
                ab.setTitle(mYear +"년"+ mMonth +"월");
            }
        });

        return view;
    }

    public int calDays(int year, int month, int day) {
        int total_day= 0;
        total_day += ( year - 1 ) * 365; // 저번 년도까지의 날의 수

        int [] month_array = new int [12]; // 배열 생성
        month_array[0] =31; // 1월
        month_array[1] =28; // 2월
        month_array[2] =31; // 3월
        month_array[3] =30; // 4월
        month_array[4] =31; // 5월
        month_array[5] =30; // 6월
        month_array[6] =31; // 7월
        month_array[7] =31; // 8월
        month_array[8] =30; // 9월
        month_array[9] =31; // 10월
        month_array[10] =30; // 11월
        month_array[11] =31; // 12월

        for (int i = 0; i < month - 1; i++){
            total_day += month_array[i];
        }
        total_day += day; // 날으 수 증가

        return total_day;
    }
}