package com.bibek.redis.service;

import com.bibek.redis.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author bibek
 * @project redis
 * @project 11/10/2021 - 8:07 AM
 **/
@Service
@CacheConfig(cacheNames = {"Customer"})
public class CoustmerServiceImpl implements CoustmerService{

    private static final Logger LOG = LoggerFactory.getLogger(CoustmerServiceImpl.class);

    @Override
    @Cacheable(key = "#id")
    public Customer getById(Long id) {
        LOG.info("Getting customer idfo ",id);
        return new Customer(id,"user " +id,"ktm");
    }
}
