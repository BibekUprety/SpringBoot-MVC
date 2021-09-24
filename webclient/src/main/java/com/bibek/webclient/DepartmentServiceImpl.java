package com.bibek.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bibek
 * @project webclient
 * @project 24/09/2021 - 12:20 PM
 **/
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    WebClient webClient;

    @Override
    public List<GetDepartmentDto> getDepartmentDto() {
        Flux<GetDepartmentDto> getDepartmentDtoFlux = webClient
                .get()
                .uri("/all")
                .retrieve()
                .bodyToFlux(GetDepartmentDto.class);

        getDepartmentDtoFlux.subscribe(System.out::println);
        List<GetDepartmentDto> getDepartmentDto = getDepartmentDtoFlux.collectList().block();

        System.out.println(getDepartmentDto);
        return getDepartmentDto;
    }
}
