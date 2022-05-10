package com.example.team1_pj2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DayAdapter extends BaseAdapter {
    private ArrayList<DayItem> dayItems;
    private int DaySelected;
    private Context Context;

    public DayAdapter(Context context, ArrayList<DayItem> dayItems) {
        this.dayItems = dayItems;
        Context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return dayItems.size();
    }

    @Override
    public Object getItem(int position) {
        return dayItems.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.day_item, parent, false);
        }
        convertView.setBackgroundColor(Color.WHITE);

        TextView dayText = convertView.findViewById(R.id.day);
        int day = dayItems.get(position).getDay();
        if (day !=0) {
            dayText.setText(day + "");
            if (day == DaySelected) {
                convertView.setBackgroundColor(Color.CYAN);
            } else {
                convertView.setBackgroundColor(Color.WHITE);
            }
        } else {
            dayText.setText("");
            convertView.setEnabled(false);
        }

        convertView.setLayoutParams(new ViewGroup.LayoutParams(parent.getWidth()/7-1, parent.getHeight()/6-1));

        return convertView;
    }

    public void setDaySelected(int day) {
        DaySelected = day;
    }
}
