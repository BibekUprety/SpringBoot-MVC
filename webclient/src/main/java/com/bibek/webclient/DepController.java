package com.bibek.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author bibek
 * @project webclient
 * @project 24/09/2021 - 12:27 PM
 **/

@RestController
@RequiredArgsConstructor
public class DepController {

    private final DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<?> getDepartmentDto(){

        return  new ResponseEntity<>(departmentService.getDepartmentDto(), HttpStatus.OK);
    }
}
