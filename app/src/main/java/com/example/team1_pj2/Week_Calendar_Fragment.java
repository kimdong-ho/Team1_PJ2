package com.example.team1_pj2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


public class Week_Calendar_Fragment extends Fragment { // 강의자료 참고

    private static final String ARG_PARAM1 = "param1"; // 키값
    private static final String ARG_PARAM2 = "param2"; // 키값
    private static final String ARG_PARAM3 = "param3"; // 키값

    private int mYear;
    private int mMonth;
    private int mDay;

    GridView gridView;

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
    public void onCreate(Bundle savedInstanceState) { // 강의자료 참고 / 초기화 하는 코드 프래그먼트가 생성될 떄 호출되는 부분
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
        //GridView gridView = (GridView)view.findViewById(R.id.days);
        gridView =view.findViewById(R.id.days);


        String[] dayLabels = showDay();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, dayLabels);
        // simpla_list_item_activated_1 은 리스트에서 아이템을 선택했을 때 선택한 아이템이 표시가 되는 레이아웃
        // getActivity() 를 통해 액티비티 인스턴스를 얻은 후에 우리가 원하는 작업을 수행하면 됩니다
        gridView.setAdapter(arrayAdapter); // setAdapter를 통해서 데이터 할당
        gridView.setSelection(0); // 반드시 Adapter 아래에 둬야한다.
        gridView.setItemChecked(0, true);
        gridView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // 단일 선택 모드
        // 그리드뷰에 데이터 집어넣는 방법
        //1. 데이터를 모은다.
        //2. 어댑터에 집어 넣는다.
        //3. GridVeiw에 어댑터를 넣는다.

        //setOnItemClickListener(new AdapterView.OnItemClickListener() { // 클릭했을 때 토스트 메시지 출력
        //    @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //        Toast.makeText(getActivity(),"position="+position,Toast.LENGTH_SHORT).show();
        //   }
        //});



        return view;
    }

    private String[] showDay() { // 배열 생성 보여지는 날의 배열
        String[] str = new String[7];
        int day = mDay;

        for (int i = 0; i < 7; i++) {
            switch (mMonth) {
                case 1: //1월
                    if (day >= 31) {  // 1월은 31일까지 그 이후면 break
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
        return str; // 값 반환
    }

    private ArrayList<EventItem> makeWeekCalendar() { // 밑에 이벤트아이템 배열 구현인데 아직 미완성
        ArrayList<EventItem> items = new ArrayList<EventItem>();
        for (int j=0; j<24;j++) { // 24시간 * 7일인 배열
            for (int i = 0; i < 7; i++) {
                items.add(new EventItem());
            }
        }
        return items; // 아이템 값 반환
    }
}