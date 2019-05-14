package com.springboot.demo.config.filter;

import org.slf4j.MDC;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * requestID
 * @version 1.0.0
 * @Description:
 * @author: weichao 2019/5/13 22 09
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/*",filterName = "loggerKeyFilter ")
public class LoggerKeyFilter implements Filter {

    private static final String LOGKEY = "requestId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String requestId = this.getLogkey();
        MDC.put(LOGKEY, requestId);
        filterChain.doFilter(servletRequest,servletResponse);
        MDC.clear();
    }

    @Override
    public void destroy() {
    }

    /**
     *
     * @return
     */
    private String getLogkey() {
        StringBuilder requestIdBuffer = new StringBuilder(UUID.randomUUID().toString());
        requestIdBuffer.insert(0,"[");
        requestIdBuffer.insert(requestIdBuffer.length(),"]");
        return requestIdBuffer.toString().replace("-","");
    }
}

