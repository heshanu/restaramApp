package com.restaturant.restaturant.springboot.service;

import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.entity.test;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();

    ResponseEntity<List<UserEntity>> findAll();
}
