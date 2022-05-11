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


public class Week_View_Fragment extends Fragment { // 키값

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
    public void onCreate(Bundle savedInstanceState) { // 강의자료 참고 // 초기화 하는 코드 프래그먼트가 생성될 떄 호출되는 부분
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mYear = getArguments().getInt(ARG_PARAM1);
            mMonth = getArguments().getInt(ARG_PARAM2);
            mDay = getArguments().getInt(ARG_PARAM3);
        }
    }

    // onCteateView 부분에 onCreate 메소드 안에서 사용할 코드를 적으면 된다.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {  // onCreate 후에 회면을 구성할 때 호출되는 부분
        View view = inflater.inflate(R.layout.week_view, container, false); // week_view xml과 연결
        ViewPager2 weekVP2 = view.findViewById(R.id.weekViewPager);
        Week_Pager_Adapter adapter = new Week_Pager_Adapter(this); // Week_Pager_Adapter 생성
        weekVP2.setAdapter(adapter);

        //int totaldays = 365;
        int totaldays = calDays(mYear,mMonth+1,mDay); // 1년의 총 날 수수
        int number = totaldays/7;

        Calendar cal = Calendar.getInstance();
        mYear = cal.get(Calendar.YEAR); // 현재 년
        mMonth = cal.get(Calendar.MONTH); // 현재 월
        mDay = cal.get(Calendar.DAY_OF_MONTH); // 현재 월의 날짜
        weekVP2.setCurrentItem(number,false); // 특정페이지로 이동하고 싶을 때 쓰는 메소드 number = 프래그먼트 번호, false = 이동스크롤 여부

        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar(); // 액션바 사용하기
        ab.setTitle(mYear+"년"+(mMonth+1)+"월"); // 현재 년월 표시


        weekVP2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // 필요한 메소드만 재정의 할 수 있게 하는 코드

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                int year = 0;
                int month = 0;
                int day = 0;
                int allday = position*7;
                int year_days = allday%365;

                //Calendar cal = Calendar.getInstance();
                //mYear = cal.get(Calendar.YEAR); // 현재 년 가져오기

                mYear = allday % 365;

                if (year_days <= 31) { // 1월 31일
                    mDay = year_days;
                    mMonth = 1;
                }
                else if (year_days <= 59) { // 2월 28일 + 31 // 59일이 넘어가면 2월로 넘어간다
                    mDay = year_days - 31;
                    mMonth = 2;
                }
                else if (year_days <= 90) { // 3월 31일 + 28 + 31
                    mDay = year_days - 59;
                    mMonth = 3;

                }
                else if (year_days <= 120) { // 4월 30일 + 31 + 28 + 31
                    mDay = year_days - 90;
                    mMonth = 4;
                }
                else if (year_days <= 151) { // 5월 31일 + 30 + 31 + 28 + 31
                    mDay = year_days - 120;
                    mMonth = 5;
                }
                else if (year_days <= 181) { // 6월 30일 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 151;
                    mMonth = 6;
                }
                else if (year_days <= 212) { // 7월 31일 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 181;
                    mMonth = 7;
                }
                else if (year_days <= 243) { // 8월 31일 + 31 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 212; 
                    mMonth = 8;
                }
                else if (year_days <= 273) { // 9월 30일 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 243;
                    mMonth = 9;
                }
                else if (year_days <= 304) { // 10월 31일 + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 273;
                    mMonth = 10;
                }
                else if (year_days <= 334) { // 11월 30일 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 304;
                    mMonth = 11;
                }
                else if (year_days <= 365){ // 12월 31일 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31 + 28 + 31
                    mDay = year_days - 334;
                    mMonth = 12;
                }
                ab.setTitle(mYear +"년"+ mMonth +"월");
            }
        });

        return view; // week_view로 반환
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
        total_day += day; // 날의 수 증가

        return total_day;
    }
}