package com.whalee.universe.config.exception;

import com.whalee.universe.common.enums.exceptions.CommonExceptionCode;
import com.whalee.universe.common.enums.exceptions.ErrorCode;
import com.whalee.universe.common.enums.exceptions.ErrorResponse;
import com.whalee.universe.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public CommonResponse<Object> exceptAll(Exception e){
        logger.warn("throwableException ::: ", e);
        ErrorCode errorCode = CommonExceptionCode.getExceptionCodeByMessage(e.getMessage());
        return handleExceptionInternal(errorCode);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResponse<Object> handleIllegalArgument(IllegalArgumentException e) {
        logger.warn("handleIllegalArgument :: ", e);
        ErrorCode errorCode = CommonExceptionCode.getExceptionCodeByMessage(e.getMessage());
        return handleExceptionInternal(errorCode);
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<Object> handleIllegalArgument(Exception e) {
        logger.warn("handleIllegalArgument :: ", e);
        ErrorCode errorCode = CommonExceptionCode.getExceptionCodeByMessage(e.getMessage());
        return handleExceptionInternal(errorCode);
    }

    private CommonResponse<Object> handleExceptionInternal(ErrorCode errorCode) {
        return CommonResponse.builder().code(errorCode.getHttpStatus().toString()).message(errorCode.getMessage()).build();
    }
}
