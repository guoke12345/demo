package com.springboot.demo.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@PropertySource("classpath:dev.properties")
@ConfigurationProperties(prefix = "config.test")
public class ConfigMethodTwo {
    private String constant;
}
