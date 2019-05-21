package com.springboot.demo.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author weichao
 * @Date 2019/5/20
 */
@Data
public class HelloDto {
    private String hello;
    private String param1;
    @NotEmpty
    private String param2;
}
