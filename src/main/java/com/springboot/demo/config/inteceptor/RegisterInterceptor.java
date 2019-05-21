package com.springboot.demo.config.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class RegisterInterceptor extends WebMvcConfigurationSupport {

    private Logger logger = LoggerFactory.getLogger(RegisterInterceptor.class);

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        logger.debug("注册拦截器");
        registry.addInterceptor(new UserTokenAppInterseptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/favicon.ico");
    }

}
