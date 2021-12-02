package com.bibek.excel.controller;

import com.bibek.excel.UserExcelImporter;
import com.bibek.excel.dto.CustomerDTO;
import com.bibek.excel.model.Customer;
import com.bibek.excel.service.CustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author bibek
 * @project excel
 * @project 30/11/2021 - 11:59 AM
 **/
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;
    private UserExcelImporter importer;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    private void save(HttpServletResponse customerDTO) throws IOException {
         customerService.export(customerDTO);
    }

    @PostMapping
    public Customer saveSs(@ModelAttribute CustomerDTO customerDTO) throws IOException {
        System.out.println("\n\n\n+here");
        return customerService.save(customerDTO);
    }

    @PostMapping("/upload")
    public void Sa(@RequestParam("file")MultipartFile file,String sheet) throws IOException {

        customerService.saveCustomerSS(file,sheet);
    }
}
