package com.springboot.demo.common.exception;

import com.springboot.demo.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 异常处理类
 * @Author zwc
 * @Date 2019/5/14
 */
@ControllerAdvice
public class BusinessExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public JsonResult handleBusinessException(BusinessException exception) {
        JsonResult result = JsonResult.getError(ResultCode.BusinessException);
        result.setMessage(exception.getMessage());

        logger.warn("业务错误:{}", exception.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult handleException(Exception exception) {
        JsonResult result = JsonResult.getError(ResultCode.UnknownException);
        result.setMessage("服务器错误");
        logger.error("服务器错误:", exception);
        return result;
    }

}
