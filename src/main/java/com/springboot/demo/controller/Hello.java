package com.springboot.demo.controller;

import com.springboot.demo.common.exception.BusinessException;
import com.springboot.demo.config.constant.ConfigMethodOne;

import com.springboot.demo.config.constant.ConfigMethodTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello extends BaseController{


    @Autowired
    private ConfigMethodOne configMethodOne;

    @Autowired
    private ConfigMethodTwo configMethodTwo;

    @RequestMapping("/hello")
    public String hello(String hello){

//        logger.info("ConfigMethodOne getContantTest:{}",configMethodOne.getContantTest());
        logger.info("configMethodTwo gettest:{}",configMethodTwo.getConstant());
        logger.info("测试日志打印！");
        int a = 2/0;
        return "OK";
    }
}
