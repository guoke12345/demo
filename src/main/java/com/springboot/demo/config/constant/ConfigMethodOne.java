package com.springboot.demo.config.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@Data
@PropertySource("classpath:dev.properties")
public class ConfigMethodOne {

    @Value("${config.test.constant}")
    private String contantTest;
}
