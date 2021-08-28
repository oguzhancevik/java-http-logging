package io.perasoft.javahttplogging.model.response;

import lombok.Data;
import lombok.ToString;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

@Data
public class HttpLogDTO {

    @ToString.Exclude
    private ContentCachingRequestWrapper request;
    @ToString.Exclude
    private ContentCachingResponseWrapper response;

    private String protocol, remote, method, uri, host, path, scheme, port, requestHeaders, requestBody;
    private String statusCode, statusValue, responseHeaders, responseBody;

    @ToString.Exclude
    private long startTime, endTime;

    public HttpLogDTO(long startTime) {
        this.startTime = startTime;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @ToString.Include
    public long duration() {
        return endTime - startTime;
    }
}
