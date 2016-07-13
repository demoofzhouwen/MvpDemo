package com.wonders.mvpdemo.presenter;

import com.wonders.mvpdemo.data.NewsData;
import com.wonders.mvpdemo.model.InitDatas;
import com.wonders.mvpdemo.model.NewsModelImpel;
import com.wonders.mvpdemo.view.NewsView;
import java.util.List;

/**
 *newsPresenter层实现类，握有view层与modul层的引用。
 */
public class NewsPresenterImpel implements NewsPresenter, InitDatas {
    private NewsView newsView;//view层引用
    private NewsModelImpel newsModel;//newsmodul层引用
    public NewsPresenterImpel(NewsView newsView) {
        this.newsView=newsView;
        this.newsModel=new NewsModelImpel();
        newsModel.setDataToPre(this);
    }

    @Override
    public void loadData() {
        newsModel.getData();
    }

    @Override
    public void setDataToPre(List<NewsData.NewslistBean> newsData) {
        newsView.setData(newsData);
    }
}
