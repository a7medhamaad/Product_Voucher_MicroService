package com.learn.voucherapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.voucherapp.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

}
