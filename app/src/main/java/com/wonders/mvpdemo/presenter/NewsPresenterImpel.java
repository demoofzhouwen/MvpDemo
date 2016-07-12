package com.wonders.mvpdemo.presenter;

import com.wonders.mvpdemo.data.NewsData;
import com.wonders.mvpdemo.model.NewsModel;
import com.wonders.mvpdemo.model.NewsModelImpel;
import com.wonders.mvpdemo.view.NewsView;

import java.util.List;

/**
 *
 */
public class NewsPresenterImpel implements NewsPresenter {
    private NewsView newsView;
    private NewsModel newsModel;
    private List<NewsData.NewslistBean> newsDatas;
    public NewsPresenterImpel(NewsView newsView) {
        this.newsView=newsView;
        this.newsModel=new NewsModelImpel();
    }

    @Override
    public void loadData() {
        newsDatas= newsModel.initData();
        newsView.setData(newsDatas);
    }
}
