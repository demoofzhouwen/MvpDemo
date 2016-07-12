package com.wonders.mvpdemo.model;

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

    @Override
    public List<NewsData.NewslistBean> initData() {
        HttpUtil.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String body = new String(responseBody);
                ObjectMapper mapper=new ObjectMapper();
                try {
                    newsData = mapper.readValue(body, NewsData.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        },key,value );
        return newsData.getNewslist();
    }
}
