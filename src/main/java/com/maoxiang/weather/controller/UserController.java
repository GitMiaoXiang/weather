package com.maoxiang.weather.controller;

import com.maoxiang.weather.constenum.ResponseEnum;
import com.maoxiang.weather.entity.User;
import com.maoxiang.weather.service.IUserService;
import com.maoxiang.weather.utils.RestResultGenerator;
import com.maoxiang.weather.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ShangGuanMingPeng
 * date: 2018/8/24 14:58
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;

    @GetMapping
    public ResultData<List<User>> queryUser(){
        List<User> users = userService.queryAll();
        ResultData resultData = RestResultGenerator.successResult(users, ResponseEnum.SUCCESS);
        return resultData;
    }
}
