package com.wonders.mvpdemo.model;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.wonders.mvpdemo.data.NewsData;
import com.wonders.mvpdemo.httputils.HttpUtil;

import java.io.IOException;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 *
 */
public class NewsModelImpel implements NewsModel {
    private String url=" http://apis.baidu.com/txapi/weixin/wxhot";
    private String key="apikey";
    private String value="5127c770a0ac79ce58099983e3a29b37";
    private NewsData newsData;
    private InitDatas datas;

    public InitDatas getDatas() {
        return datas;
    }

    public void setDatas(InitDatas datas) {
        this.datas = datas;
    }

    @Override
    public List<NewsData.NewslistBean> initData() {
        return newsData.getNewslist();
    }
    @Override
    public void getData() {
        HttpUtil.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String body = new String(responseBody);
                Log.i("查询新闻数据",body);
                ObjectMapper mapper=new ObjectMapper();
                try {
                    newsData = mapper.readValue(body, NewsData.class);
                    datas.initData(newsData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("连接失败，错误信息",new String(responseBody));
            }
        },key,value );
    }

}
