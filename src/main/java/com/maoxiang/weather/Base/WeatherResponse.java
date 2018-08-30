package com.maoxiang.weather.Base;

import lombok.Data;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 18:46
 * Description:
 */
@Data
public class WeatherResponse {
    /**
     * data : {"yesterday":{"date":"28日星期二","high":"高温 29℃","fx":"无持续风向","low":"低温 25℃","fl":"<![CDATA[<3级]]>","type":"阵雨"},"city":"深圳","aqi":"26","forecast":[{"date":"29日星期三","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"无持续风向","type":"大雨"},{"date":"30日星期四","high":"高温 28℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"无持续风向","type":"大雨"},{"date":"31日星期五","high":"高温 29℃","fengli":"<![CDATA[<3级]]>","low":"低温 26℃","fengxiang":"无持续风向","type":"雷阵雨"},{"date":"1日星期六","high":"高温 31℃","fengli":"<![CDATA[<3级]]>","low":"低温 27℃","fengxiang":"无持续风向","type":"阵雨"},{"date":"2日星期天","high":"高温 32℃","fengli":"<![CDATA[<3级]]>","low":"低温 28℃","fengxiang":"无持续风向","type":"多云"}],"ganmao":"天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。","wendu":"27"}
     * status : 1000
     * desc : OK
     */

    private Object data;
    private int status;
    private String desc;

    public static final int OK = 1000;  //
}
