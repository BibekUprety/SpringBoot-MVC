package com.bibek.department.controller;

import com.bibek.department.entity.Department;
import com.bibek.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@RequestBody Department department){
        log.info("Department is created");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartmentById(@PathVariable Long id){
        log.info("department id is get byu id");
        System.out.println("hello");
        return departmentService.getDepartmentId(id);
    }
    @GetMapping("/all")
    public List<Department> getAll(){
        return  departmentService.findAll();
    }
}
