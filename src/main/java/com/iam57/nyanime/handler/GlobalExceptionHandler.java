package com.iam57.nyanime.handler;

import com.iam57.nyanime.common.exception.NyanimeException;
import com.iam57.nyanime.common.result.HttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author iam57
 * @since 2024-03-20 10:41:58
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(NyanimeException.class)
    public HttpResult<Void> exceptionHandler(NyanimeException exception) {
        return HttpResult.error(exception);
    }
}
