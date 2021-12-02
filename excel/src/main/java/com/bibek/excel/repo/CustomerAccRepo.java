package com.bibek.excel.repo;

import com.bibek.excel.model.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bibek
 * @project excel
 * @project 30/11/2021 - 11:57 AM
 **/
public interface CustomerAccRepo extends JpaRepository<CustomerAccount,Integer> {
}
