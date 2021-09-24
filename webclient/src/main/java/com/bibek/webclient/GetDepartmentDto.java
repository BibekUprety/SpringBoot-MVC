package com.bibek.webclient;

import lombok.*;

/**
 * @author bibek
 * @project webclient
 * @project 24/09/2021 - 12:17 PM
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class GetDepartmentDto {

    private Long departmentId;

    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
