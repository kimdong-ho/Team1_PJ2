package com.example.team1_pj2;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import java.util.Calendar;

public class Week_Pager_Adapter extends FragmentStateAdapter {
    private static int ITEM = 12 * 7 * 4 * 24;

    public Week_Pager_Adapter(Fragment fragment) {
        super(fragment);
    }

    @Override
    public Fragment createFragment(int position) { // 프래그먼트 생성
        int year;
        int month;
        int day;
        int allday = position * 7; // 총 날의 수
        int year_days = allday % 365; // 계산용 날의 수

        //Calendar cal = Calendar.getInstance();
        //year = cal.get(Calendar.YEAR); // 현재 년 가져오기

        year = allday%365;

        if (year_days <= 31) { // 1월 // 31일까지 1월 그 이후면은 2월로 넘어간다
            day = year_days; // 1월은 31일
            month = 1;
        }
        else if (year_days <= 59) { // 2월
            day = year_days - 31; // 2월은 day의 수에서 1월의 31일을 빼야한다
            month = 2;
        }
        else if (year_days <= 90) { // 3월
            day = year_days - 59; // 똑같이 반복
            month = 3;

        }
        else if (year_days <= 120) { // 4월
            day = year_days - 90;
            month = 4;
        }
        else if (year_days <= 151) { // 5월
            day = year_days - 120;
            month = 5;
        }
        else if (year_days <= 181) { // 6월
            day = year_days - 151;
            month = 6;
        }
        else if (year_days <= 212) { // 7월
            day = year_days - 181;
            month = 7;
        }
        else if (year_days <= 243) { // 8월
            day = year_days - 212;
            month = 8;
        }
        else if (year_days <= 273) { // 9월
            day = year_days - 243;
            month = 9;
        }
        else if (year_days <= 304) { // 10월
            day = year_days - 273;
            month = 10;
        }
        else if (year_days <= 334) { // 11월
            day = year_days - 304;
            month = 11;
        }
        else { // 12월
            day = year_days - 334;
            month = 12;
        }
        Week_Calendar_Fragment week = Week_Calendar_Fragment.newInstance(year,month,day); // newInstance를 해야만 다음 프래그먼트가 재 생성 될 떄 newInstance() 메소드에서
                                                                                          // set 해주는 bundle을 다시 받을 수 있다. 그러면 bundle을 또 생성할 필요 없이 기존의 것을 사용할 수 있다.
        return week;
    }

    public int getItemCount() {
        return ITEM;
    } // 전체 아이템 개수 리턴
}
