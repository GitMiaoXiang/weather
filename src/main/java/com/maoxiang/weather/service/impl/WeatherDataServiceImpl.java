package com.maoxiang.weather.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maoxiang.weather.Base.AddrConst;
import com.maoxiang.weather.Base.HttpAPIService;
import com.maoxiang.weather.Base.WeatherResponse;
import com.maoxiang.weather.constenum.ResponseEnum;
import com.maoxiang.weather.dao.RedisDao;
import com.maoxiang.weather.entity.Weather;
import com.maoxiang.weather.service.IWeatherService;
import com.maoxiang.weather.utils.RestResultGenerator;
import com.maoxiang.weather.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/29 17:06
 * Description:
 */
@Service
public class WeatherDataServiceImpl implements IWeatherService {

    @Autowired
    private HttpAPIService httpAPIService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisDao redisDao;

    /**
     * 根据城市id获取
     * @param cityId
     * @return
     * @throws Exception
     */
    @Override
    public ResultData<Weather> getDataByCityId(String cityId) throws Exception {
        String url = AddrConst.ADDRESS_QUERY_WEATHER_INFO + "citykey=" + cityId;
        ResultData resultData = getData(url);
        return resultData;
    }

    /**
     * 根据城市名字获取信息
     * @param cityName
     * @return
     * @throws Exception
     */
    @Override
    public ResultData<Weather> getDataByName(String cityName) throws Exception {
        String url = AddrConst.ADDRESS_QUERY_WEATHER_INFO + "city=" + cityName;
        ResultData resultData = getData(url);
        return resultData;
    }

    /**
     * 获取天气数据
     *
     * @param url
     * @return
     */
    private ResultData getData(String url) throws Exception {
        String strBody;
        ResultData resultData;
        Boolean aBoolean = redisTemplate.hasKey(url);
        if(aBoolean){
            strBody = redisDao.stringGetStringByKey(url);
        }else{
            strBody = httpAPIService.doGet(url);
            redisDao.stringSetString(url,strBody);
        }
        if (strBody != null) {
            ObjectMapper mapper = new ObjectMapper();
            WeatherResponse weatherResponse = mapper.readValue(strBody, WeatherResponse.class);
            if (weatherResponse.getStatus() == WeatherResponse.OK) {
                resultData = RestResultGenerator.successResult(weatherResponse.getData(), ResponseEnum.SUCCESS);
            } else {
                resultData = RestResultGenerator.errorResult(ResponseEnum.FAILED);
            }
        }else{
            resultData = RestResultGenerator.errorResult(ResponseEnum.FAILED);
        }
        return resultData;
    }
}
