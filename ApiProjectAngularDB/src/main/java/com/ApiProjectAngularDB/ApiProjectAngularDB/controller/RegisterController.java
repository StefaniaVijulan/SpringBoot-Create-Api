package com.ApiProjectAngularDB.ApiProjectAngularDB.controller;

import com.ApiProjectAngularDB.ApiProjectAngularDB.model.User;
import com.ApiProjectAngularDB.ApiProjectAngularDB.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:4200")
    public User registerUser(@RequestBody User user) throws Exception {
        String formatEmail =user.getEmail();
        if(formatEmail != null && !"".equals(formatEmail)){
           User userObj = registerService.getUserByEmail(formatEmail);
           if(userObj != null){
               throw new Exception("This user already exist");
           }
        }
            User newUser = null;
            newUser = registerService.addUser(user);
            return newUser;
    }
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:4200")
    public User loginUser(@RequestBody User user) throws Exception {
        String formatEmail = user.getEmail();
        String formatPassword = user.getPassword();
        User userObj = null;
        if(formatEmail != null && formatPassword !=null) {
            userObj = registerService.getUserByEmailAndPassword(formatEmail, formatPassword);
        }
        if(userObj == null){
            throw new Exception("This user does not exist");
        }
        return userObj;
    }
}
