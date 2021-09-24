package com.bibek.webclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author bibek
 * @project webclient
 * @project 24/09/2021 - 12:12 PM
 **/
@Configuration
public class UtilityConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8090/department")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
