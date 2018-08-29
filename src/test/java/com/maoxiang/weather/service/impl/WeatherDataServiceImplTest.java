package com.maoxiang.weather.service.impl;

import com.maoxiang.weather.Base.WeatherResponse;
import com.maoxiang.weather.service.IWeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class WeatherDataServiceImplTest {

    @Autowired
    private IWeatherService weatherService;

    @Test
    public void getDataByCityId() {
        try {
            WeatherResponse resultData = weatherService.getDataByCityId("深圳");
            System.out.println(resultData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataByName() {
    }
}