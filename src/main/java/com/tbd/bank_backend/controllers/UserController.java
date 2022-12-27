package com.tbd.bank_backend.controllers;

import com.tbd.bank_backend.models.User;
import com.tbd.bank_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService uServ;

    @GetMapping
    public List<User> getAllUsers() {
        return uServ.getAllUsers();
    }

    @GetMapping("/{userName}")
    public Optional<User> getUserById(@PathVariable("userName")String userName) {
        return uServ.getUserById(userName);
    }

    @PostMapping
    public boolean registerUser(@RequestBody User newUser) {
        User createdUser = uServ.registerUser(newUser);
        return createdUser != null;
    }

    @GetMapping(value = "/{userName}", params = {"validate=true"})
    public boolean userExists(@PathVariable("userName")String userName) {
        return uServ.userExists(userName);
    }
}
