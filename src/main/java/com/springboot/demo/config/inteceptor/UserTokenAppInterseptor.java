package com.springboot.demo.config.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserTokenAppInterseptor implements HandlerInterceptor {
    private Logger logger = LoggerFactory.getLogger(UserTokenAppInterseptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("User token app interceptor!");
        return true;
    }

}
