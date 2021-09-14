package com.bibek.customvalidation.controller;

import com.bibek.customvalidation.entity.Test;
import com.bibek.customvalidation.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {

    private TestService t;

    public TestController(TestService t) {
        this.t = t;
    }

    @PostMapping
    public ResponseEntity<Test> save(@Valid @RequestBody Test test){
        return new ResponseEntity<>(t.addTest(test), HttpStatus.CREATED);
    }
}
