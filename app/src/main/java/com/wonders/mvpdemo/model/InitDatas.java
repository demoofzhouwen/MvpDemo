package com.wonders.mvpdemo.model;

import com.wonders.mvpdemo.data.NewsData;

import java.util.List;

/**
 *定义modul层向presenter层传输数据接口
 */
public interface InitDatas {
    void setDataToPre(List<NewsData.NewslistBean> newsData);
}
