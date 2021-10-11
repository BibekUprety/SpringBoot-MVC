package com.bibek.redis.controller;

import com.bibek.redis.Customer;
import com.bibek.redis.service.CoustmerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bibek
 * @project redis
 * @project 11/10/2021 - 8:04 AM
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CoustmerService coustmerService;

    public CustomerController(CoustmerService coustmerService) {
        this.coustmerService = coustmerService;
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id){
        return coustmerService.getById(id);
    }
}
