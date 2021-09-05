package com.bibek.reddis.springboot.service;

import com.bibek.reddis.springboot.model.User;

import java.util.List;

public interface UserService {
    Boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, User user);
}
