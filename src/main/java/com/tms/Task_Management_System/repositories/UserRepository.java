package com.tms.Task_Management_System.repositories;

import com.tms.Task_Management_System.entity.userEntity.User;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsUserByEmail(String email);
    Boolean existsUserByMobile(String mobile);
    Boolean existsUserByUserId( Long userId);
    Optional<User> findByEmailAndUserId(String email, Long id);
    Optional<User> findByMobileAndUserId(String email, Long id);
    Optional<User> findByUserId(Long userId);
}
