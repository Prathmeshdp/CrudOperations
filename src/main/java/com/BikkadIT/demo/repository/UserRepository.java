package com.BikkadIT.demo.repository;

import com.BikkadIT.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {

}

