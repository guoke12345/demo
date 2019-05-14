package com.springboot.demo.config.inteceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class RegisterInterceptor extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserTokenAppInterseptor()).addPathPatterns("/**").excludePathPatterns("/favicon.ico");
        super.addInterceptors(registry);
    }

}
