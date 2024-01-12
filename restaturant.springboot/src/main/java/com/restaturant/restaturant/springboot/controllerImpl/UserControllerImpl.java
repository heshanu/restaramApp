package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.UserController;
import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.entity.test;
import com.restaturant.restaturant.springboot.service.AuthService;
import com.restaturant.restaturant.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;
    @Override
    public String getUser() {
        return "user";
    }

    @Override
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        try{
            return userService.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
