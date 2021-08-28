package io.perasoft.javahttplogging.handler;

import io.perasoft.javahttplogging.model.exception.BusinessValidationException;
import io.perasoft.javahttplogging.model.response.HttpErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static io.perasoft.javahttplogging.util.Constants.HTTP.REQUEST_ID_PROPERTY_NAME;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String requestId = ThreadContext.get(REQUEST_ID_PROPERTY_NAME);
        log.error("", ex);

        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        HttpErrorDTO httpError = HttpErrorDTO.builder().requestId(requestId).message(ex.getMessage()).build();
        if (ex instanceof BusinessValidationException) {
            BusinessValidationException businessException = (BusinessValidationException) ex;
            httpError.setCode(businessException.getValidationRule().getCode());
            httpStatus = businessException.getValidationRule().getHttpStatus();
        }

        return handleExceptionInternal(ex, httpError, new HttpHeaders(), httpStatus, request);
    }

}