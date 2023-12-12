package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.AuthController;
import com.restaturant.restaturant.springboot.dto.SignUpRequest;
import com.restaturant.restaturant.springboot.dto.UserDTO;
import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthService authService;
    @Override
    public ResponseEntity<String> signUpUser(SignUpRequest signUpRequest) {
       try{
           if(!Objects.isNull(signUpRequest) && !Objects.isNull(signUpRequest.getEmail()) && !Objects.isNull(signUpRequest.getName()) && !Objects.isNull(signUpRequest.getPassword())){
               authService.createUser(signUpRequest);
               return new ResponseEntity<>("user created successfully", HttpStatus.OK);
           }
           else{
               return new ResponseEntity<>("please fill all fileds",HttpStatus.BAD_REQUEST);
           }

       }
       catch (Exception e){
              e.printStackTrace();
       }
       return new ResponseEntity<>("unable to signup",HttpStatus.BAD_REQUEST);
    }
}
