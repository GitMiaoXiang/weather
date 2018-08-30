package com.maoxiang.weather.service.impl;

import com.maoxiang.weather.entity.Weather;
import com.maoxiang.weather.service.IWeatherService;
import com.maoxiang.weather.utils.ResultData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherDataServiceImplTest {

    @Autowired
    private IWeatherService weatherService;

    @Test
    public void getDataByCityId() {
        try {
            ResultData<Weather> resultData = weatherService.getDataByName("深圳");
            System.out.println(resultData.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataByName() {
    }
}