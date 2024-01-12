package com.restaturant.restaturant.springboot.controller;

import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.entity.test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/user")
public interface UserController {
    @GetMapping("/")
    public String getUser();

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllUsers();

}
