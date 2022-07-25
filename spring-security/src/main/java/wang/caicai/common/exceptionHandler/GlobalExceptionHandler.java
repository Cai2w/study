package wang.caicai.common.exceptionHandler;


import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Results;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import wang.caicai.common.enums.SystemStatus;

import java.util.stream.Collectors;

/**
 * @author wangpeixu
 * @date 2021/12/5 20:52
 * @description 统一异常处理
 */
@ResponseBody
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        log.error(e.getMessage(), e);
        return Results.error(SystemStatus.UNKNOWN_ERROR);
    }

    /**
     * 自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(SystemRuntimeException.class)
    public Result error(SystemRuntimeException e) {
        log.error(e.getMessage(), e);
        return Results.error(e);
    }


    /**
     * 全局处理所有使用了@validation校验参数的controller
     *
     * @param e 捕获到validation抛出异常
     * @return 返回参数中所有的校验错误，以,分隔不用的错误信息
     */
    @ExceptionHandler(BindException.class)
    public Result exceptionHandler(BindException e) {
        String errors = e.getBindingResult().getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
        log.error("Request params error,caught by global exception handler,{}", errors);
        return Results.error(SystemStatus.UNKNOWN_ERROR,errors);
    }
}
