package com.wonders.mvpdemo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wonders.mvpdemo.R;
import com.wonders.mvpdemo.adapter.ListAda;
import com.wonders.mvpdemo.data.NewsData;
import com.wonders.mvpdemo.presenter.NewsPresenterImpel;
import com.wonders.mvpdemo.view.NewsView;

import java.util.List;



/**
 *
 */
public class NewsFragment extends Fragment implements NewsView {


    private View inflate;
    private ListView listView;
    private NewsPresenterImpel presenterImpel;
    private Handler handler=new Handler();
    //具体的数据加载操作
    private Runnable LOAD_DATA=new Runnable(){
        @Override
        public void run() {
            presenterImpel.loadData();
        }
    };
    private ListAda listAda;

    public NewsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            initView(inflater, container);
        }
        handler.postDelayed(LOAD_DATA,500);
        return inflate;
    }

    /**
     * 控件初始化
     * @param inflater
     * @param container
     */
    private void initView(LayoutInflater inflater, ViewGroup container) {
        inflate = inflater.inflate(R.layout.fragment_news, container, false);
        listView = (ListView) inflate.findViewById(R.id.lv);
        listAda = new ListAda(this.getContext());
        listView.setAdapter(listAda);
        presenterImpel = new NewsPresenterImpel(this);
    }

    /**
     * 判断当前用户是否可视
     * 如果不可视时取消延时加载
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!isVisibleToUser){
            handler.removeCallbacks(LOAD_DATA);
        }
    }

    /**
     * 加载数据
     * @param newsData
     */
    @Override
    public void setData(List<NewsData.NewslistBean> newsData) {

    }
}
