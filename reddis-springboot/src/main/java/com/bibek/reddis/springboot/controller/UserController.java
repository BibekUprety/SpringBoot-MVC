package com.bibek.reddis.springboot.controller;

import com.bibek.reddis.springboot.model.User;
import com.bibek.reddis.springboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        Boolean result = userService.saveUser(user);
        if (result) {
            return ResponseEntity.ok("User is created successfully");
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping
    public ResponseEntity<List<User>> fetchAllUser() {
        List<User> users = userService.fetchAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.fetchUserById(id);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        boolean result = userService.deleteUser(id);
        if (result) {
            return ResponseEntity.ok("USer is deleted successfully");
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable Long id) {
        boolean result = userService.updateUser(id, user);
        if (result) {
            return ResponseEntity.ok("User Is Updated");
        } else return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
