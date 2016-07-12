package com.wonders.mvpdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wonders.mvpdemo.R;
import com.wonders.mvpdemo.data.NewsData;
import com.wonders.mvpdemo.presenter.NewsPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */
public class ListAda extends BaseAdapter {
    private List<NewsData.NewslistBean> newslist;
    private Context context;
    private  ViewHolder viewHolder;
    public ListAda(Context context) {
        this.context=context;
        newslist=new ArrayList<>();
    }

    /**
     * 加载一组数据
     * @param datas
     */
    public void addData( List<NewsData.NewslistBean> datas){
        newslist.addAll(datas);
    }

    /**
     * 加载一条数据
     * @param datas
     */
    public void addData( NewsData.NewslistBean datas){
        newslist.add(datas);
    }

    @Override
    public int getCount() {
        return newslist.size();
    }

    @Override
    public Object getItem(int position) {
        return newslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=LayoutInflater.from(context).inflate(R.layout.listview_news,parent,false);
             viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(newslist.get(position).getTitle());
        viewHolder.description.setText(newslist.get(position).getDescription());
        return convertView;
    }
    class ViewHolder{
        TextView title;
        TextView description;

        public ViewHolder(View convertView) {
            title=(TextView) convertView.findViewById(R.id.tv_title);
            description=(TextView) convertView.findViewById(R.id.tv_description);
        }
    }
}
