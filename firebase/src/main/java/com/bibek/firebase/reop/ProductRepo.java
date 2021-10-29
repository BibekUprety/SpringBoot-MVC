package com.bibek.firebase.reop;

import com.bibek.firebase.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bibek
 * @project firebase
 * @project 28/10/2021 - 7:55 AM
 **/
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
