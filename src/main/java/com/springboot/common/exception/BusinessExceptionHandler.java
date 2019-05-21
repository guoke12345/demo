package com.springboot.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 异常处理类
 * @Author zwc
 * @Date 2019/5/14
 */
@RestControllerAdvice
public class BusinessExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(BusinessExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)
    public JsonResult handleBusinessException(BusinessException exception) {
        JsonResult result = JsonResult.getError(ResultCode.BusinessException);
        result.setMessage(exception.getMessage());

        logger.error("业务错误:{}", exception.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public JsonResult handleException(Exception exception) {
        JsonResult result = JsonResult.getError(ResultCode.UnknownException);
        result.setMessage("服务器错误");
        logger.error("服务器错误:", exception);
        return result;
    }

    @ExceptionHandler(BindException.class)
    public JsonResult handleBindException(BindException exception) {
        JsonResult result = JsonResult.getError(ResultCode.ParamException);

        Set<ValidationError> errors = new HashSet<ValidationError>();
        for (FieldError er : exception.getFieldErrors()) {

            errors.add(new ValidationError(er.getObjectName(), er.getField(), er.getDefaultMessage()));
        }

        result.setData(errors);

        logger.warn("参数绑定错误:{}", exception.getObjectName());

        return result;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        JsonResult result = JsonResult.getError(ResultCode.ParamException);

        Set<ValidationError> errors = new HashSet<ValidationError>();
        for (FieldError er : exception.getBindingResult().getFieldErrors()) {

            errors.add(new ValidationError(er.getObjectName(), er.getField(), er.getDefaultMessage()));
        }

        result.setData(errors);

        logger.warn("参数验证错误:{}", exception.getBindingResult().getObjectName());

        return result;
    }

}
