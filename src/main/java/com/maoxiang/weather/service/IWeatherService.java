package com.maoxiang.weather.service;

import com.maoxiang.weather.Base.WeatherResponse;

import java.io.IOException;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 17:04
 * Description: 天气数据接口
 */
public interface IWeatherService {


    WeatherResponse getDataByCityId(String cityId) throws IOException;

    WeatherResponse getDataByName(String cityName) throws IOException;


}
