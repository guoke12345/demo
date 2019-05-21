package com.springboot.demo.controller;

import com.springboot.common.exception.BusinessException;
import com.springboot.common.exception.JsonResult;
import com.springboot.common.exception.ValidationError;
import com.springboot.demo.config.constant.ConfigMethodOne;

import com.springboot.demo.config.constant.ConfigMethodTwo;
import com.springboot.demo.controller.dto.HelloDto;
import com.springboot.demo.entity.HlHlappMember;
import com.springboot.demo.mapper.HlHlappMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public JsonResult hello(@Validated HelloDto helloDto) {

        logger.info(helloDto.toString());

        return JsonResult.getOK();
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
