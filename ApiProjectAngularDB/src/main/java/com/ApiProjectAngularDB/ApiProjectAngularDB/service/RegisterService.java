package com.ApiProjectAngularDB.ApiProjectAngularDB.service;

import com.ApiProjectAngularDB.ApiProjectAngularDB.model.User;
import com.ApiProjectAngularDB.ApiProjectAngularDB.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private RegisterRepository registerRepository;

    public User addUser(User user){
       return registerRepository.save(user);
    }
    public User getUserByEmail(String emailUser){
        return registerRepository.findUserByEmail(emailUser);
    }
    public User getUserByEmailAndPassword(String emailUser, String passwordUser){
        return registerRepository.findUserByEmailAndPassword(emailUser, passwordUser);
    }}
