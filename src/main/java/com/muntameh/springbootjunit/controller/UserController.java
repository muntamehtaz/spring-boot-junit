package com.muntameh.springbootjunit.controller;

import com.muntameh.springbootjunit.model.User;
import com.muntameh.springbootjunit.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        if (!userList.isEmpty()) {
            return ResponseEntity.ok(userList);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null)
            return ResponseEntity.ok(user);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateUserAddress(@RequestBody User user) {
        userService.updateUserAddress(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public String deleteUserById(@PathVariable String id) {
        return userService.deleteUserById(id);
    }
}
