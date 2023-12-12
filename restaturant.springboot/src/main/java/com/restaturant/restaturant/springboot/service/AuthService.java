package com.restaturant.restaturant.springboot.service;

import com.restaturant.restaturant.springboot.dto.SignUpRequest;
import com.restaturant.restaturant.springboot.dto.UserDTO;

public interface AuthService {
  UserDTO createUser(SignUpRequest signUpRequest);
}
