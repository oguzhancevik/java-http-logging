#Java HTTP Request Response Logging


#### Examples

* GET API
``` 
HttpLogDTO(protocol=HTTP/1.1, remote=0:0:0:0:0:0:0:1, method=GET, uri=http://localhost:8080/api/test, host=localhost, path=/api/test, scheme=http, port=8080, requestHeaders={postman-token=[45873447-b566-4fcc-849c-98fcf5bb47ed], host=[localhost:8080], connection=[keep-alive], cache-control=[no-cache], accept-encoding=[gzip, deflate, br], user-agent=[PostmanRuntime/7.28.4], accept=[*/*]}, requestBody=, statusCode=200, statusValue=OK, responseHeaders={Keep-Alive=timeout=60, X-Request-Id=0944d82d-c827-41c7-96b8-7b73915912d6, Connection=keep-alive, Content-Length=4, Date=Sat, 28 Aug 2021 15:27:24 GMT, Content-Type=text/plain;charset=UTF-8}, responseBody=test, duration=10)
```

* POST API
``` 
HttpLogDTO(protocol=HTTP/1.1, remote=0:0:0:0:0:0:0:1, method=POST, uri=http://localhost:8080/api, host=localhost, path=/api, scheme=http, port=8080, requestHeaders={content-length=[57], postman-token=[cf6325b9-54c2-4255-925f-b8e7037c4bfc], host=[localhost:8080], content-type=[application/json], connection=[keep-alive], cache-control=[no-cache], accept-encoding=[gzip, deflate, br], user-agent=[PostmanRuntime/7.28.4], accept=[*/*]}, requestBody={
    "provider": "GitHub",
    "username": "pera-soft"
}, statusCode=200, statusValue=OK, responseHeaders={Keep-Alive=timeout=60, X-Request-Id=3cf1272f-0ab4-44b5-9508-5572c628cd92, Connection=keep-alive, Content-Length=44, Date=Sat, 28 Aug 2021 15:33:58 GMT, Content-Type=application/json}, responseBody={"provider":"GitHub","username":"pera-soft"}, duration=5)
```

* PUT API
``` 
HttpLogDTO(protocol=HTTP/1.1, remote=0:0:0:0:0:0:0:1, method=PUT, uri=http://localhost:8080/api, host=localhost, path=/api, scheme=http, port=8080, requestHeaders={content-length=[57], postman-token=[159c6824-23a9-48f3-b5b8-a0a91bb9c73f], host=[localhost:8080], content-type=[application/json], connection=[keep-alive], cache-control=[no-cache], accept-encoding=[gzip, deflate, br], user-agent=[PostmanRuntime/7.28.4], accept=[*/*]}, requestBody=, statusCode=400, statusValue=Bad Request, responseHeaders={X-Request-Id=ea9fd57e-4922-4e16-802b-41471b6ae689, Connection=close, Content-Length=95, Date=Sat, 28 Aug 2021 15:35:53 GMT, Content-Type=application/json}, responseBody={"requestId":"ea9fd57e-4922-4e16-802b-41471b6ae689","code":"001","message":"Object Not Found!"}, duration=62)
``` 

* DELETE API
``` 
HttpLogDTO(protocol=HTTP/1.1, remote=0:0:0:0:0:0:0:1, method=DELETE, uri=http://localhost:8080/api, host=localhost, path=/api, scheme=http, port=8080, requestHeaders={content-length=[57], postman-token=[3c905eff-bcfa-40cc-9c1f-5674ccf6078e], host=[localhost:8080], content-type=[application/json], connection=[keep-alive], cache-control=[no-cache], accept-encoding=[gzip, deflate, br], user-agent=[PostmanRuntime/7.28.4], accept=[*/*]}, requestBody=, statusCode=406, statusValue=Not Acceptable, responseHeaders={Keep-Alive=timeout=60, X-Request-Id=575a1e45-537a-4f07-8a90-d48ba2fb7697, Connection=keep-alive, Content-Length=93, Date=Sat, 28 Aug 2021 15:36:41 GMT, Content-Type=application/json}, responseBody={"requestId":"575a1e45-537a-4f07-8a90-d48ba2fb7697","code":"002","message":"Invalid Object!"}, duration=9)
``` 