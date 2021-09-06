package com.bibek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String get(){
        return "Hello word";
    }

    @GetMapping("/restricted")
    public String get1(){
        return "to see the text we need to login";
    }
}
