package com.bibek.redis.service;

import com.bibek.redis.Customer;

/**
 * @author bibek
 * @project redis
 * @project 11/10/2021 - 8:07 AM
 **/
public interface CoustmerService {

    Customer getById(Long id);
}
