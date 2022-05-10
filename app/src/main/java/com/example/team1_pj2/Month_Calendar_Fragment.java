package com.example.team1_pj2;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Month_Calendar_Fragment extends Fragment {

    private static final String Param1 = "YEAR";
    private static final String Param2 = "MONTH";
    private static final String Param3 = "DAY";

    private int mYear;
    private int mMonth;
    private int mDaySelected;

    DayAdapter mDayAdapter;

    public Month_Calendar_Fragment() {
    }

    public static Month_Calendar_Fragment newInstance(int year, int month, int day) {

        Month_Calendar_Fragment fragment = new Month_Calendar_Fragment();
        Bundle args = new Bundle();
        args.putInt(Param1, year);
        args.putInt(Param2, month);
        args.putInt(Param3, day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.month_calendar, container, false);

        ArrayList<DayItem> items = makeMonthCalendar(mYear, mMonth);
        mDayAdapter = new DayAdapter(getActivity(),items);
        mDayAdapter.setDaySelected(mDaySelected);
        GridView gridView = view.findViewById(R.id.days);
        gridView.setAdapter(mDayAdapter);
        gridView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int day = ((DayItem) mDayAdapter.getItem(position)).getDay();
                mDayAdapter.setDaySelected(day);
                mDayAdapter.notifyDataSetChanged();
                Toast.makeText(getActivity(),
                        mYear+"년"+(mMonth+1)+"월"+day+"일", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mYear = getArguments().getInt(Param1);
            mMonth = getArguments().getInt(Param2);
            mDaySelected = getArguments().getInt(Param3);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private ArrayList<DayItem> makeMonthCalendar(int year, int month) {
        ArrayList<DayItem> items = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.set(year,month,1);      // year년 month월 1일 설정

        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // year년 month월 1일의 요일 (1~7)
        int lastDayofMonth= cal.getActualMaximum(Calendar.DATE); // year년 month월의 마지막 날짜

        int date = 1;
        for (int i=1; i<=7*6; i++) {
            if (i < startDayOfWeek || (i >= startDayOfWeek + lastDayofMonth)) {
                items.add(new DayItem(0));
            } else {
                DayItem item = new DayItem(date++);
                items.add(item);
            }
        }
        return items;
    }
}