package io.perasoft.javahttplogging.controller;

import io.perasoft.javahttplogging.model.exception.BusinessValidationException;
import io.perasoft.javahttplogging.model.exception.BusinessValidationRule;
import io.perasoft.javahttplogging.util.Constants.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(API.BASE_MAPPING)
public class MyRestController {

    @GetMapping("/{code}")
    public ResponseEntity get(@PathVariable("code") String code) {
        return ResponseEntity.ok(code);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Object request) {
        return ResponseEntity.ok(request);
    }

    @PutMapping
    public ResponseEntity put() {
        throw new BusinessValidationException(BusinessValidationRule.OBJECT_NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity delete() {
        throw new BusinessValidationException(BusinessValidationRule.INVALID_OBJECT);
    }

}
