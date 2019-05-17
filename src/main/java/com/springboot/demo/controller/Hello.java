package com.springboot.demo.controller;

import com.springboot.demo.config.constant.ConfigMethodOne;

import com.springboot.demo.config.constant.ConfigMethodTwo;
import com.springboot.demo.entity.HlHlappMember;
import com.springboot.demo.mapper.HlHlappMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello extends BaseController{


    @Autowired
    private ConfigMethodOne configMethodOne;

    @Autowired
    private ConfigMethodTwo configMethodTwo;

    @Autowired
    private HlHlappMemberMapper hlHlappMemberMapper;

    @RequestMapping("/hello")
    public String hello(String hello){

        logger.info("configMethodTwo gettest:{}",configMethodTwo.getConstant());
        logger.info("测试日志打印！");
        int a = 2/0;
        return "OK";
    }

    @RequestMapping("/testMybatiesPlus")
    public String testMybatiesPlus() {
        HlHlappMember member = hlHlappMemberMapper.selectById(617);
        HlHlappMember member1 = new HlHlappMember();
        member1.setId(1);
        logger.info(member.toString());
        return "select over";
    }
}
