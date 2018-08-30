package com.maoxiang.weather.service;

import com.maoxiang.weather.entity.Weather;
import com.maoxiang.weather.utils.ResultData;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 17:04
 * Description: 天气数据接口
 */
public interface IWeatherService {


    ResultData<Weather> getDataByCityId(String cityId) throws Exception;

    ResultData<Weather> getDataByName(String cityName) throws Exception;


}
