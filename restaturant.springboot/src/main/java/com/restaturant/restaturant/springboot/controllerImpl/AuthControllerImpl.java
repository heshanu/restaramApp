package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.AuthController;
import com.restaturant.restaturant.springboot.dto.AuthenticationRequest;
import com.restaturant.restaturant.springboot.dto.AuthenticationResponse;
import com.restaturant.restaturant.springboot.dto.SignUpRequest;
import com.restaturant.restaturant.springboot.dto.UserDTO;
import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.repo.UserRepo;
import com.restaturant.restaturant.springboot.service.AuthService;
import com.restaturant.restaturant.springboot.service.jwt.UserDetailsServiceImpl;
import com.restaturant.restaturant.springboot.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo userRepo;

    public AuthControllerImpl(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

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

    @Override
    public AuthenticationResponse createAuthenticationToken(AuthenticationRequest authenticationRequest, HttpServletResponse response ) throws IOException {
        try{
            authenticationManager.authenticate(new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),authenticationRequest.getPassword()));
        }
        catch(BadCredentialsException e){
            throw new BadCredentialsException("incorrect username or password",e);
        }
        catch (DisabledException e){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"user is disabled");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt=jwtUtil.generateToken(userDetails.getUsername());
        Optional<UserEntity> optionalUser=userRepo.findFirstByEmail(authenticationRequest.getEmail());
        AuthenticationResponse authenticationResponse=new AuthenticationResponse();
        if(optionalUser.isPresent()){
            authenticationResponse.setJwt(jwt);
            authenticationResponse.setUserRole(optionalUser.get().getUserRole());
            authenticationResponse.setUserId(optionalUser.get().getId());
        }
        return authenticationResponse;
    }
}
