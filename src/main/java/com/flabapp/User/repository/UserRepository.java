package com.flabapp.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flabapp.User.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    
}
