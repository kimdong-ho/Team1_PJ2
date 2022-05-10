package com.example.team1_pj2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import java.util.ArrayList;


public class Week_Calendar_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1"; // 키값
    private static final String ARG_PARAM2 = "param2"; // 키값
    private static final String ARG_PARAM3 = "param3"; // 키값

    private int mYear = 0;
    private int mMonth = 0;
    private int mDay = 0;

    GridView daysGV;

    public Week_Calendar_Fragment() {

    }

    public static Week_Calendar_Fragment newInstance(int year, int month, int day) { // 강의자료 참고
        Week_Calendar_Fragment fragment = new Week_Calendar_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, year);
        args.putInt(ARG_PARAM2, month);
        args.putInt(ARG_PARAM3, day);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { // 강의자료 참고
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mYear = getArguments().getInt(ARG_PARAM1); // 초기화
            mMonth = getArguments().getInt(ARG_PARAM2); // 초기화
            mDay = getArguments().getInt(ARG_PARAM3); // 초기화
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) { // 강의자료 참고
        View view = inflater.inflate(R.layout.week_calendar, container, false);
        GridView daysGV = (GridView)view.findViewById(R.id.days);


        String[] dayLabels = showDay();

        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        android.R.layout.simple_list_item_activated_1,
                        dayLabels);

        daysGV.setAdapter(arrayAdapter);
        daysGV.setSelection(0);
        daysGV.setItemChecked(0, true);

        //setOnItemClickListener(new AdapterView.OnItemClickListener() { // 클릭했을 때 토스트 메시지 출력
        //    @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        Toast.makeText(getActivity(),"position="+position,Toast.LENGTH_SHORT).show();
        //   }
        //});

        return view;
    }

    private String[] showDay() {
        String[] str = new String[7];
        int day = mDay;

        for (int i = 0; i < 7; i++) {
            switch (mMonth) {
                case 1: //1월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 2: //2월
                    if (day >= 28) {
                        day = 1;
                    }
                    break;
                case 3: //3월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 4: //4월
                    if (day >= 30) {
                        day = 1;
                    }
                case 5: //5월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 6: //6월
                    if (day >= 30) {
                        day = 1;
                    }
                case 7: //7월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 8: //8월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 9: //9월
                    if (day >= 30) {
                        day = 1;
                    }
                case 10: //10월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
                case 11: //11월
                    if (day >= 30) {
                        day = 1;
                    }
                    break;
                case 12: //12월
                    if (day >= 31) {
                        day = 1;
                    }
                    break;
            }
            str[i] = "" + day++;
        }
        return str;
    }

    private ArrayList<EventItem> makeWeekCalendar() {
        ArrayList<EventItem> items = new ArrayList<EventItem>();
        for (int j=0; j<24;j++) {
            for (int i = 0; i < 7; i++) {
                items.add(new EventItem());
            }
        }
        return items;
    }
}