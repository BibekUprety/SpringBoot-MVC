package com.bibek.customvalidation.repo;

import com.bibek.customvalidation.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<Test,Integer> {
}
