package com.BikkadIT.demo.controller;

import com.BikkadIT.demo.model.User;
import com.BikkadIT.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@ResponseBody
//@RequestMapping
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceI userServiceI;

//  @RequestMapping(method = RequestMethod.POST,name ="/users")
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        logger.info("Entering the request for save user data");

        User saveUser = userServiceI.createUser(user);

        logger.info("Completed the request for save user data");

        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){

        logger.info("Entering the request for get all user data");

        List<User> allUsers = userServiceI.getAllUsers();

        logger.info("Completed the request for get all user data");

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @GetMapping("/getSingleUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){

        logger.info("Entering the request for get user data by id");

        User singleUser = userServiceI.getSingleUser(userId);

        logger.info("Completed the request for get user data by id");

        return new ResponseEntity<>(singleUser, HttpStatus.OK);

    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {

        logger.info("Entering the request for update user data");

        User updateUser = userServiceI.updateUser(user,userId);

        logger.info("Completed the request for update user data");

        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){

        logger.info("Entering the request for delete user data");

        userServiceI.deleteUser(userId);

        logger.info("Completed the request for delete user data");

        return new ResponseEntity<>("Resource Delete Successfully !!", HttpStatus.OK);
    }


}

