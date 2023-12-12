package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.UserController;
import com.restaturant.restaturant.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Override
    public String getUser() {
        return "user";
    }
}
