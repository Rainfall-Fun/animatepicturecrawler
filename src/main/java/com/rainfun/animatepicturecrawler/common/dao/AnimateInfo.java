package com.rainfun.animatepicturecrawler.common.dao;

import lombok.Data;

@Data
public class AnimateInfo {

    String originalName; // 原名

    String translatedName;// 通常译名

    String romanRead; // 罗马音

    String pictureOfBase64; //base64封面图

    String broadcastStartDate; // 播出时间

    String broadcastStartMonth;  // 播出所属月

    String broadcastCount; // 话数

    String alias; // 别名或另译名

    String bangumiUrl; // bangumi地址

    String officialWebsite; // 官网

}
