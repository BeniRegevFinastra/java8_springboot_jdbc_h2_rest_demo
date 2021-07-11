package com.finastra.java8_springboot_jdbc_h2_rest_demo.controller;

import com.finastra.java8_springboot_jdbc_h2_rest_demo.model.User;
import com.finastra.java8_springboot_jdbc_h2_rest_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/health")
    public String health() {
        return "Health check successful!\nHello from java8_springboot_jdbc_h2_rest_demo";
    }

    @PostMapping(path = "/users/demo")
    public User createUserDemo() {
        return userService.createUserDemo();
    }

    @PostMapping(path = "/users")
    public User createUser(@RequestBody String requestBody) {
        return userService.createUser(requestBody);
    }

    @GetMapping("/users/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/users/{id}/asString")
    public String getByIdAsString(@PathVariable String id) {
        return userService.getById(id).toJson();
    }

    @GetMapping(path = "/users/{id}")
    public User getById(@PathVariable String id) {
        return userService.getById(id);
    }

    @GetMapping(path = "/users/lastname/{lastName}")
    public List<User> getByLastName(@PathVariable() String lastName) {
        return userService.getByLastName(lastName);
    }

    @PutMapping(path="/users/{id}")
    public User updateUser(@PathVariable String id,
                           @RequestBody String requestBody) {
        return userService.updateUser(id, requestBody);
    }

    @GetMapping(path = "/add")
    public Integer updateUser() {
        return userService.addNumbers(12,2);
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }
}
