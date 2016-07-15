package com.wonders.mvpdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.wonders.mvpdemo.R;
import com.wonders.mvpdemo.view.MainActivity;

import java.util.ArrayList;

/**
 *
 */
public class PopAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> titleList;
    private ViewHolder viewHolder;

    public PopAdapter(Context context) {
        this.context=context;
        this.titleList=new ArrayList<>();
    }

    public void addData(String title) {
        titleList.add(title);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return titleList.size();
    }

    @Override
    public Object getItem(int position) {
        return titleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.poplist,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(titleList.get(position));
        return convertView;
    }
    private class ViewHolder {
        private Button title;
        public ViewHolder(View convertView) {
            title=(Button) convertView.findViewById(R.id.poptitle);
        }
    }
}
