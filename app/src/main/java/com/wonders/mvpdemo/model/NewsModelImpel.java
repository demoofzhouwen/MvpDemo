package com.wonders.mvpdemo.model;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
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
    private InitDatas dataToPre;
    private String src;
    private String rand;

    public void setDataToPre(InitDatas dataToPre) {
        this.dataToPre = dataToPre;
    }
    @Override
    public void getData(Bundle data) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("num","10");
        requestParams.put("page","1");
        if(data!=null){
            Bundle data1 = data.getBundle("data");
            src=data1.getString("popTitle");
            rand=data1.getString("popRand");
        }
        if(!TextUtils.isEmpty(src)){
            requestParams.put("src",src);
        }
        if(!TextUtils.isEmpty(rand)){
            requestParams.put("rand",rand);
        }
        HttpUtil.get(url,requestParams,  new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String body = new String(responseBody);
                Log.i("查询新闻数据",body);
                ObjectMapper mapper=new ObjectMapper();
                try {
                    newsData = mapper.readValue(body, NewsData.class);
                    if(newsData.getMsg().equals("success")){
                        dataToPre.setDataToPre(newsData.getNewslist());
                    }
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
