package com.restaturant.restaturant.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/user")
public interface UserController {
    @GetMapping("/")
    public String getUser();

}
