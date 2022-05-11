package com.example.team1_pj2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Time_Adapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<EventItem> items;
    int mTimeSelected;

    public Time_Adapter(Context context, ArrayList<EventItem> Item) {
        mContext = context;
        this.items= Item;
    }

    public int getCount(){
        return items.size();
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    void setTimeSelection(int position) {

        mTimeSelected = position;
    }
    
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.time_item, parent, false );
        }
        convertView.setBackgroundColor(Color.BLACK);

        TextView text = convertView.findViewById(R.id.time_text);

        if (position == mTimeSelected) {
            text.setBackgroundColor(Color.CYAN);
        }
        else {
            text.setBackgroundColor(Color.WHITE);
        }

        int w = 100;
        int h = 200;

        convertView.setLayoutParams(new ViewGroup.LayoutParams(w, h));

        return convertView;



        }
    }
}

