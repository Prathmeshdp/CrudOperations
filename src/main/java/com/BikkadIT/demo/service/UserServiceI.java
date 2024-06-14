package com.BikkadIT.demo.service;

import com.BikkadIT.demo.model.User;

import java.util.List;

public interface UserServiceI {
// CURD

    // CREATE
        User createUser(User user);
    // UPDATE
        User updateUser(User user, Long userId);

    // GET Single User
        User getSingleUser(Long userId);

    // GET All Data
        List<User> getAllUsers();


    // DELETE
        void deleteUser(Long userId);

}
