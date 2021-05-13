package com.rainfun.animatepicturecrawler.common.bangumi;

import com.rainfun.animatepicturecrawler.config.AccessUrl;
import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import static com.rainfun.animatepicturecrawler.config.Config.BANGUMI_CONFIG;
import static java.util.Arrays.asList;

public class BangumiLauncher {
    public List<String> getAnimationList() {

        List<String> idList = new ArrayList<>();

        for (int t = 0; t < 5; t++) {
            Launcher launcher = new Launcher();
            try (
                    //不使用GUP加速，不启动浏览器
                    SessionFactory factory = launcher.launch(asList("--disable-gpu", "--headless"))
            ) {
                String context = factory.createBrowserContext();


                try (Session session = factory.create(context)) {

                    //设置爬取网站的链接
                    session.navigate(AccessUrl.getAnimeByYearMonth(2020, 1, 1));//todo 改为循环获取动画标题
                    //设置超时
                    session.waitDocumentReady(30 * 1000);
                    //使用xPath解析DOM树得到需要的内容


                    if (session.getText("/html").equals("")) {
                        System.out.println("第" + t + "次：空页面，正在重试");
                    } else {
                        for (int i = 1; i <= 24; i++) {
                            String titleText = session.getText(BANGUMI_CONFIG, i);   //todo 配置适配bangumi
                            idList.add(titleText);
                            System.out.println(titleText);
                        }
                        //关闭操作回收内存  使用时报错直接使用下面的kill鲨进程还挺好使:] 不知道是不是
                        // factory.disposeBrowserContext(context);
                        break;
                    }
                }catch(Exception e){
//                    System.out.println(e);
                    continue;
                }

                //关闭操作进程
                launcher.kill();
            }
        }
        //获取番剧地址列表
        return idList;

    }


}
