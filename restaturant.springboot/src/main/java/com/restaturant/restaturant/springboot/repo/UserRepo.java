package com.restaturant.restaturant.springboot.repo;

import com.restaturant.restaturant.springboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findFirstByEmail(String email);
}
