package com.foodwastage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodwastage.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
