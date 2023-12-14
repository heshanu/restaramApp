package com.restaturant.restaturant.springboot.serviceImpl;

import com.restaturant.restaturant.springboot.dto.SignUpRequest;
import com.restaturant.restaturant.springboot.dto.UserDTO;
import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.enums.UserRoleEnum;
import com.restaturant.restaturant.springboot.repo.UserRepo;
import com.restaturant.restaturant.springboot.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdminAccount(){
        try {
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public UserDTO createUser(SignUpRequest signUpRequest) {
        try{
            UserEntity user=new UserEntity();
            user.setName(signUpRequest.getName());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(signUpRequest.getPassword());
            user.setUserRole(UserRoleEnum.CUSTOMER);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserEntity createUser=userRepo.save(user);

            UserDTO createUserDTO=new UserDTO();

            createUserDTO.setId(createUser.getId());
            createUserDTO.setName(createUser.getName());
            createUserDTO.setEmail(createUser.getEmail());
            createUserDTO.setUserRole(createUser.getUserRole());
            System.out.println("createUserDTO: "+createUserDTO);
            return createUserDTO;

        }catch (Exception e){
            e.printStackTrace();
        }
        return new UserDTO();
    }
}
