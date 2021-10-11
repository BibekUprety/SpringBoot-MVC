package com.bibek.redis;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

/**
 * @author bibek
 * @project redis
 * @project 11/10/2021 - 8:09 AM
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer implements Serializable {

    private Long id;
    private String name;
    private String address;
}
