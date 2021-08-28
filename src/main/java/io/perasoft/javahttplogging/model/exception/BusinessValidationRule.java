package io.perasoft.javahttplogging.model.exception;

import io.perasoft.javahttplogging.util.Constants.EXCEPTION;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BusinessValidationRule {

    OBJECT_NOT_FOUND("001", "Object Not Found!"),
    INVALID_OBJECT("002", "Invalid Object!", HttpStatus.NOT_ACCEPTABLE);

    private String code = EXCEPTION.DEFAULT_CODE;
    private final String message;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST; // use only 4XX and 5XX codes

    BusinessValidationRule(String code, String message) {
        this.code = code;
        this.message = message;
    }

    BusinessValidationRule(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
