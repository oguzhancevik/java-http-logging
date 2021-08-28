package io.perasoft.javahttplogging.model.response;

import io.perasoft.javahttplogging.util.Constants.EXCEPTION;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HttpErrorDTO {

    private String requestId;

    @Builder.Default
    private String code = EXCEPTION.DEFAULT_CODE;

    private String message;
}
