package com.rainfun.animatepicturecrawler.config;

public class Config {
    /**
     * 保存路径
     */
    public static final String SAVE_LOCATION = "E:\\Pixiv\\";

    public static final String PIXIV_CONFIG = "//*[@id=\"%d\"]/h2/a/@href";

//    public static final String BANGUMI_CONFIG = "/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[%d]";
    public static final String BANGUMI_CONFIG = "/html/body/div[1]/div[2]/div[2]/div[1]/div[2]/ul/li[%d]/div/h3/a/@href";
//                              '/html/body/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[1]/a/span[2]''
//                               /html/body/div/div[2]/div[6]/div/div/div[2]/div/div[1]/div/div[1]/ul/li[2]/a/span[2]'
    // todo yande 有api 可以直接调用 可改为调用api方法
    // todo yande爬取适配待解决
    public static final String YANDE_CONFIG = "//h2/a/@href";
//    public static final String YANDE_CONFIG = "//*[@id=\"%d\"]/pools/pools";

}
