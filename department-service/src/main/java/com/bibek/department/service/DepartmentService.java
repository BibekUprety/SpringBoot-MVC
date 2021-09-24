package com.bibek.department.service;

import com.bibek.department.entity.Department;
import com.bibek.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentId(Long id) {
        return departmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
}
