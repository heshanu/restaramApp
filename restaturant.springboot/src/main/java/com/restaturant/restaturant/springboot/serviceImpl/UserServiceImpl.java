package com.restaturant.restaturant.springboot.serviceImpl;

import com.restaturant.restaturant.springboot.entity.UserEntity;
import com.restaturant.restaturant.springboot.entity.test;
import com.restaturant.restaturant.springboot.repo.UserRepo;
import com.restaturant.restaturant.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return  userRepository.findFirstByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
            }
        };
    }

    @Override
    public ResponseEntity<List<UserEntity>> findAll() {
        try{
            return (ResponseEntity<List<UserEntity>>) userRepository.findAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null);
    }
}
