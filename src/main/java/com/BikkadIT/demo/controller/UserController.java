package com.BikkadIT.demo.controller;

import com.BikkadIT.demo.model.User;
import com.BikkadIT.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@ResponseBody
//@RequestMapping
@RestController
public class UserController {

    @Autowired
    private UserServiceI userServiceI;

//  @RequestMapping(method = RequestMethod.POST,name ="/users")
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User saveUser = userServiceI.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> allUsers = userServiceI.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }


    @GetMapping("/getSingleUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId){

        User singleUser = userServiceI.getSingleUser(userId);

        return new ResponseEntity<>(singleUser, HttpStatus.OK);

    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {

        User updateUser = userServiceI.updateUser(user,userId);

        return new ResponseEntity<>(updateUser, HttpStatus.CREATED);

    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){

        userServiceI.deleteUser(userId);

        return new ResponseEntity<>("Resource Delete Successfully !!", HttpStatus.OK);
    }


}

