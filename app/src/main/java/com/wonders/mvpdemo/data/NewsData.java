package com.wonders.mvpdemo.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 *
 */
public class NewsData {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2016-07-01","title":"专利纠纷升温！高通补诉魅族：拆成9个案子各索赔100万元","description":"TechWeb","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510629.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MTE3MzE4MTAyMQ==&idx=1&mid=2651134347&sn=5af2b0edf7ce2be2506e2f5d55bfb7bf"},{"ctime":"2016-07-01","title":"同样都是学生，为什么做人的差别这么大呢","description":"捧腹笑话","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510659.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5ODAxNTQ0MA==&idx=3&mid=2653892682&sn=8f8be5b7370e102abd97c12952909e59"},{"ctime":"2016-07-01","title":"人生本就如此的艰难，有些事情何必要拆穿？","description":"捧腹笑话","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510631.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5ODAxNTQ0MA==&idx=4&mid=2653892682&sn=6873cf7450943ae6094f907ca95f05ee"},{"ctime":"2016-07-01","title":"你说啥？什么叫读书的最高境界：人书合一","description":"捧腹笑话","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510637.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5ODAxNTQ0MA==&idx=1&mid=2653892682&sn=4ec8ff732d36d9432264775f8f9d718c"},{"ctime":"2016-07-01","title":"每日捧腹段子精选：石头剪刀布有什么含义？","description":"捧腹笑话","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510632.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5ODAxNTQ0MA==&idx=2&mid=2653892682&sn=273badec92ac12bcfb97bdc72f15ebc4"},{"ctime":"2016-07-01","title":"【节操回收站】在图书馆，我抱着黑丝妹的腿一通舔~","description":"嘻嘻哈哈","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510680.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5OTQwNzA4Mw==&idx=3&mid=2650257160&sn=73de51db528c098bc1166fb0998e7768"},{"ctime":"2016-07-01","title":"荷兰人口密度那么高，凭什么人人住别墅？","description":"壹读","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510713.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=OTE4MzAyODYx&idx=1&mid=2652194769&sn=ba14656087968b04695742dcb0030854"},{"ctime":"2016-07-01","title":"中国为什么没有\u201c世界一流大学\u201d？","description":"新京报书评周刊","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510710.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTUxOTc4Mw==&idx=1&mid=2650451859&sn=92134661cca9b8725c233f79e8c8fd0c"},{"ctime":"2016-07-01","title":"他曾预言的未来，是否就是我们的现在？逝者托夫勒","description":"新京报书评周刊","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510709.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTUxOTc4Mw==&idx=3&mid=2650451859&sn=9161080c1d8eb207d5650108e3a5743e"},{"ctime":"2016-07-01","title":"《神魔道》横店发布会郑恺张雨绮百世绝恋","description":"横店影视城","picUrl":"http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510732.jpg/640","url":"http://mp.weixin.qq.com/s?__biz=MjM5NTI1MjcyMA==&idx=1&mid=2650245091&sn=8d944b5485b9820902f5bee7c3717f39"}]
     */
    @JsonIgnore
    private int code;
    @JsonIgnore
    private String msg;
    /**
     * ctime : 2016-07-01
     * title : 专利纠纷升温！高通补诉魅族：拆成9个案子各索赔100万元
     * description : TechWeb
     * picUrl : http://zxpic.gtimg.com/infonew/0/wechat_pics_-6510629.jpg/640
     * url : http://mp.weixin.qq.com/s?__biz=MTE3MzE4MTAyMQ==&idx=1&mid=2651134347&sn=5af2b0edf7ce2be2506e2f5d55bfb7bf
     */

    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
