package com.maoxiang.weather.entity;

import lombok.Data;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 16:29
 * Description: 昨天天气信息
 */
@Data
public class Yesterday {

    /**Data
     * date : 28日星期二
     * high : 高温 29℃
     * fx : 无持续风向
     * low : 低温 25℃
     * fl : <![CDATA[<3级]]>
     * type : 阵雨
     */

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
