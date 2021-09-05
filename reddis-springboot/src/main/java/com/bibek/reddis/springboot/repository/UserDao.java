package com.bibek.reddis.springboot.repository;

import com.bibek.reddis.springboot.model.User;

import java.util.List;

public interface UserDao {
    Boolean saveUser(User user);

    List<User> fetchAllUser();

    User fetchUserById(Long id);

    boolean deleteUser(Long id);

    boolean updateUser(Long id, User user);
}
