package com.maoxiang.weather.entity;

import lombok.Data;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 11:48
 * Description: 预报信息
 */
@Data
public class Forecast {

    /**
     * date : 29日星期三
     * high : 高温 28℃
     * fengli : <![CDATA[<3级]]>
     * low : 低温 25℃
     * fengxiang : 无持续风向
     * type : 大雨
     */

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
