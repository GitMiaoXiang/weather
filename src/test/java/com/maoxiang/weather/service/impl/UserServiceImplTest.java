package com.maoxiang.weather.service.impl;

import com.maoxiang.weather.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest{

    @Autowired
    IUserService userService;

    @Test
    public void queryAll(){
        System.out.println(userService.queryAll());
    }
}