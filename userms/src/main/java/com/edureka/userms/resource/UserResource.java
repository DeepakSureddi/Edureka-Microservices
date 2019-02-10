package com.edureka.userms.resource;

import com.edureka.userms.model.User;
import com.edureka.userms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List getUsers() {
        LOGGER.info("User Resource getUsers called");
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUsers(@PathVariable Long userId) {
        LOGGER.info("User Resource getSingleUser called");
        return userService.getSingleUser(userId);
    }

    @PostMapping("/users")
    public ResponseEntity createUsers(@RequestBody User user) {
        LOGGER.info("User Resource create user called");
        userService.createUser(user);
        return ResponseEntity.created(URI.create("")).build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity deleteUsers(@PathVariable Long userId) {
        LOGGER.info("User Resource delete user called");
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@RequestBody User user){
        LOGGER.info("User Resource update user called");
        userService.updateUser(user);
        return ResponseEntity.ok().build();
    }
}
