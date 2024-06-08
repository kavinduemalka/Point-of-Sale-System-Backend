package com.posystem.posystem.controller;

import com.posystem.posystem.Service.UserService;
import com.posystem.posystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);

        return ResponseEntity.status(201).body(createdUser);
    }

}
