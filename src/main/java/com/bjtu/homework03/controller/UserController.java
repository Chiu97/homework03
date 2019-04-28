package com.bjtu.homework03.controller;

import com.bjtu.homework03.entity.User;
import com.bjtu.homework03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{uname}")
    public User getUser( @PathVariable("uname") String uname){
        List<User> users = userRepository.findAll();
        for (int i = 0;i<users.size();i++){
            if (users.get(i).getUname().equals(uname)){
                return users.get(i);
            }
        }
        return null;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
