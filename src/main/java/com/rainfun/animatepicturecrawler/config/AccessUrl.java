package com.rainfun.animatepicturecrawler.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessUrl {

    /**
     * Pixiv普通排行榜
     */
    public static final String pixivNormalRank =
            "https://www.pixiv.net/ranking.php?mode=daily&content=illust";

    /**
     * PixivR18排行榜
     */
    public static final String pixivR18Rank =
            "https://www.pixiv.net/ranking.php?mode=daily_r18&content=illust";

    /**
     * yande主页
     */
    public static final String yandeHomePage =
            "https://yande.re/pool.xml";
//            "https://yande.re/post";

    /**
     * yande带标签
     *
     * @param s 标签名
     * @return 带标签的url
     */
    public static String getYandeWithTag(String s) {
        return "https://yande.re/post?tags=inashishi" + s;
    }

    /**
     * Pixiv某一天的排行榜
     *
     * @param date
     * @return
     */
    public static String getPixivOneDayRank(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = sdf.format(date);
        String d = dateStr.replace("-", "");

        return "https://www.pixiv.net/ranking.php?mode=daily&content=illust&date=" + d + "";
    }

    /***
     * 获取某年某月的动画列表
     * @param year 年
     * @param month 月
     * @param page
     * @return url
     */
    public static String getAnimeByYearMonth(int year, int month, int page) {
        return "https://bgm.tv/anime/browser/airtime/" + year + "-" + month + "?page=" + page;
    }

    /**
     * 百度搜索链接
     * @param wd
     * @return
     */
    public static String getBaiduSearchUrl(String wd) {
        return "https://www.baidu.com/s?ie=UTF-8&wd=" + wd;
    }
}
