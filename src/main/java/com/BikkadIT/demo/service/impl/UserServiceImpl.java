package com.BikkadIT.demo.service.impl;

import com.BikkadIT.demo.model.User;
import com.BikkadIT.demo.repository.UserRepository;
import com.BikkadIT.demo.service.UserServiceI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceI {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        logger.info("Intiating the dao call for the save user data");

        User saveUser = userRepository.save(user);

        logger.info("Completed the dao call for the save user data");
        return saveUser;
    }

    @Override
    public User updateUser(User user, Long userId) {

        User user1 = userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setAbout(user.getAbout());

        User updatedUser = userRepository.save(user1);


        return updatedUser;
    }

    @Override
    public User getSingleUser(Long userId) {

       User user =  userRepository.findById(userId).orElseThrow(()-> new RuntimeException("Resource Not Found On Server ! "));
        return user;

    }
//      Optional<User> user =  userRepository.findById(userId);
//
//      if (user.isPresent()){
//          return user.get();
//      }else {
//          throw new NullPointerException("Resource Not Found On Server ! "+ userId);
//      }
//
//    }

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = userRepository.findAll();

        return allUsers;
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("Resource Not Found On Server ! "));

        userRepository.delete(user);

    }
}
