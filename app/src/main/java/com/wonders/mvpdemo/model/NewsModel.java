package com.wonders.mvpdemo.model;

import com.wonders.mvpdemo.data.NewsData;

import java.util.List;

/**
 * Created by bio on 2016/7/1.
 */
public interface NewsModel {
    List<NewsData.NewslistBean> initData();
}
