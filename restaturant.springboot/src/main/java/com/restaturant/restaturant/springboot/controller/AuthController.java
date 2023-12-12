package com.restaturant.restaturant.springboot.controller;

import com.restaturant.restaturant.springboot.dto.SignUpRequest;
import com.restaturant.restaturant.springboot.dto.UserDTO;
import com.restaturant.restaturant.springboot.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth")
public interface AuthController{

@PostMapping("/signIn")
    public ResponseEntity<String> signUpUser(@RequestBody(required = true) SignUpRequest signUpRequest);
}
