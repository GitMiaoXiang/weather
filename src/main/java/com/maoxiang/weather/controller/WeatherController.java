package com.maoxiang.weather.controller;

import com.maoxiang.weather.constenum.ResponseEnum;
import com.maoxiang.weather.entity.Weather;
import com.maoxiang.weather.service.IWeatherService;
import com.maoxiang.weather.utils.RestResultGenerator;
import com.maoxiang.weather.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/30 10:10
 * Description:
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping
    public ResultData<Weather> queryWeather() {
        ResultData<Weather> weatherResponse;
        try {
            weatherResponse = weatherService.getDataByName("深圳");
        } catch (Exception e) {
            weatherResponse = RestResultGenerator.errorResult(ResponseEnum.FAILED);
            e.printStackTrace();
        }
        return weatherResponse;
    }
}
