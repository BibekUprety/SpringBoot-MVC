package com.bibek.customvalidation.service;

import com.bibek.customvalidation.entity.Test;
import com.bibek.customvalidation.repo.TestRepo;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    private TestRepo testRepo;

    public TestServiceImpl(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    @Override
    public Test addTest(Test test) {
        return testRepo.save(test);
    }
}
