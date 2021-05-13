package com.rainfun.animatepicturecrawler.common.Yande;

import com.rainfun.animatepicturecrawler.common.Cdp4jStarter;
import com.rainfun.animatepicturecrawler.config.AccessUrl;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

import java.util.List;

import static java.util.Arrays.asList;

public class YandeLauncher extends Cdp4jStarter {

    public List<String> getPicTitleList() {
        //存放获取到的插画id

        Launcher launcher = new Launcher();
        try (
                //不使用GUP加速，不启动浏览器
                SessionFactory factory = launcher.launch(asList("--disable-gpu", "--headless"))
        ) {
            String context = factory.createBrowserContext();

            try (Session session = factory.create(context)) {
                //设置爬取网站的链接
                session.navigate(AccessUrl.yandeHomePage);
                //设置超时
                session.waitDocumentReady(100 * 1000);
                //使用xPath解析DOM树得到需要的内容
//                for (int i = 1; i <= 20; i++) {
                String titleText = session.getBrowserContextId();
                System.out.println(titleText);
//                }

                //关闭操作回收内存  使用时报错直接使用下面的kill鲨进程还挺好使:] 不知道是不是
//                factory.disposeBrowserContext(context);
            }
            //关闭操作进程
            launcher.kill();

            //获取图片地址列表
            return null;
        }
    }
}
