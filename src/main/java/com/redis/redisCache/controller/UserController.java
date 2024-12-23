package com.redis.redisCache.controller;

import com.redis.redisCache.Dto.UserDto;
import com.redis.redisCache.entity.Users;
import com.redis.redisCache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.UserSessionEvent;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Users> addUser(@RequestBody UserDto userDto) {
        Users savedUser = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Users> getUser(@PathVariable Long Id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(Id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String response = userService.deleteUser(id);
        return ResponseEntity.ok(response);
    }


}
