package com.rainfun.animatepicturecrawler.common;

import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Cdp4jStarter {

    /**
     * 获取图片标签列表
     * @param url 地址
     * @param config 爬取配置<--按照xPATH定位配置正则参数
     * @return
     */
    protected List<String> getPicTitleList(String url) {
        //存放获取到的插画id
        List<String> idList = new ArrayList<>();

        Launcher launcher = new Launcher();
        try (
                //不使用GUP加速，不启动浏览器
                SessionFactory factory = launcher.launch(asList("--disable-gpu", "--headless"))
        ) {
            String context = factory.createBrowserContext();

            try (Session session = factory.create(context)) {

                //设置爬取网站的链接
                session.navigate(url);
                //设置超时
                session.waitDocumentReady(30 * 1000);
                //使用xPath解析DOM树得到需要的内容

                //关闭操作回收内存  使用时报错直接使用下面的kill鲨进程还挺好使:] 不知道是不是
//                factory.disposeBrowserContext(context);
            }
            //关闭操作进程
            launcher.kill();

            //获取图片地址列表
            return idList;
        }
    }
}
