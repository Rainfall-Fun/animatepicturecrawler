package com.rainfun.animatepicturecrawler;

import com.rainfun.animatepicturecrawler.common.Yande.YandeLauncher;
import com.rainfun.animatepicturecrawler.common.bangumi.BangumiLauncher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;

@SpringBootTest
class AnimatepicturecrawlerApplicationTests {

    @Test
    void contextLoads() {
        YandeLauncher yandeLauncher = new YandeLauncher();
        yandeLauncher.getPicTitleList();
//        PixivLauncher pixivLauncher=new PixivLauncher();
//        pixivLauncher.getPixivPictureList();
    }

    @Test
    void demo() {
        String methodUrl = "http://110.32.44.11:8086/sp-test/usertest/1.0/query";
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String line = null;
        try {
            URL url = new URL(methodUrl + "?mobile=15334567890&name=zhansan");
            connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
            connection.setRequestMethod("GET");// 默认GET请求
            connection.connect();// 建立TCP连接
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
                StringBuilder result = new StringBuilder();
                // 循环读取流
                while ((line = reader.readLine()) != null) {
                    result.append(line).append(System.getProperty("line.separator"));// "\n"
                }
                System.out.println(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }

    }

    @Test
    void demo1(){
        BangumiLauncher bangumiLauncher =new BangumiLauncher();

        System.out.println(bangumiLauncher.getAnimationList());

    }

}
