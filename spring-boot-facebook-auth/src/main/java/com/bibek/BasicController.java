package com.bibek;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/")
    public String HomeController() {

        return "Hello Word";
    }

    @GetMapping("/facebook")
    public String home() {
        return "the facebook id is required to login ";
    }
}
