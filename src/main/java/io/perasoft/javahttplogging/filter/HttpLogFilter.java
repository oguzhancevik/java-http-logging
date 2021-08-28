package io.perasoft.javahttplogging.filter;

import io.perasoft.javahttplogging.model.response.HttpLogDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.perasoft.javahttplogging.util.Constants.HTTP.REQUEST_ID_PROPERTY_NAME;

@Component
@Slf4j
public class HttpLogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpLogDTO httpLog = new HttpLogDTO(System.currentTimeMillis());

        String requestId = UUID.randomUUID().toString();
        response.addHeader(REQUEST_ID_PROPERTY_NAME, requestId);
        ThreadContext.put(REQUEST_ID_PROPERTY_NAME, requestId);

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        httpLog.setResponseBody(new String(responseWrapper.getContentAsByteArray())); // response body must be retrieve before copyBodyToResponse() method
        responseWrapper.copyBodyToResponse();

        collectHttpInfo(requestWrapper, responseWrapper, httpLog);
        log.info(httpLog.toString());
        ThreadContext.remove(REQUEST_ID_PROPERTY_NAME);
    }

    private HttpLogDTO collectHttpInfo(HttpServletRequest request, HttpServletResponse response, HttpLogDTO httpLog) {
        String scheme = request.getScheme();
        String host = request.getServerName();
        String port = String.valueOf(request.getLocalPort());
        String path = request.getServletPath();
        String parameters = request.getParameterMap().keySet().stream()
                .map(key -> key + "=" + request.getParameterMap().get(key)[0]).collect(Collectors.joining("&"));

        Map<String, List<String>> requestHeaders = Collections.list(request.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        h -> Collections.list(request.getHeaders(h))
                ));

        Map<String, String> responseHeaders = response.getHeaderNames()
                .stream()
                .collect(Collectors.toMap(h -> h, response::getHeader));

        httpLog.setProtocol(request.getProtocol());
        httpLog.setRemote(request.getRemoteAddr());
        httpLog.setMethod(request.getMethod());
        httpLog.setUri(scheme + "://" + host + ":" + port + path + (StringUtils.isNotBlank(parameters) ? "?" + parameters : ""));
        httpLog.setHost(host);
        httpLog.setPath(path);
        httpLog.setScheme(scheme);
        httpLog.setPort(port);
        httpLog.setRequestHeaders(requestHeaders.toString());
        httpLog.setRequestBody(new String(((ContentCachingRequestWrapper) request).getContentAsByteArray()));
        httpLog.setStatusCode(String.valueOf(response.getStatus()));
        httpLog.setStatusValue(Objects.requireNonNull(HttpStatus.resolve(response.getStatus())).getReasonPhrase());
        httpLog.setResponseHeaders(responseHeaders.toString());
        httpLog.setEndTime(System.currentTimeMillis());

        return httpLog;
    }

}