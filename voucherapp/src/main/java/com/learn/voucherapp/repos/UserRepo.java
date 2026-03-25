package com.learn.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.voucherapp.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
 
	User findByEmail(String email);
}

