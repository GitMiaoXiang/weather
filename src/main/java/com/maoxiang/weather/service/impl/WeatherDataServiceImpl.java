package com.maoxiang.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maoxiang.weather.Base.AddrConst;
import com.maoxiang.weather.Base.WeatherResponse;
import com.maoxiang.weather.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 17:06
 * Description:
 */
@Service
public class WeatherDataServiceImpl implements IWeatherService  {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) throws IOException {
        String url = AddrConst.ADDRESS_QUERY_WEATHER_INFO + "citykey=" + cityId;
        WeatherResponse resultData = getData(url);
        return resultData;
    }

    @Override
    public WeatherResponse getDataByName(String cityName) throws IOException {
        String url = AddrConst.ADDRESS_QUERY_WEATHER_INFO + "city=" + cityName;
        WeatherResponse resultData = getData(url);
        return resultData;
    }

    private WeatherResponse getData(String url) throws IOException {
        ResponseEntity<String> weatherStr = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resultData;
        String strBody = null;
        if(weatherStr.getStatusCodeValue()==200){
            strBody = weatherStr.getBody();
        }
        resultData = mapper.readValue(strBody, WeatherResponse.class);
        return resultData;
    }
}
