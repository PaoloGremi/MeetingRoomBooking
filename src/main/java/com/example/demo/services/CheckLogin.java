package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckLogin {

    private UserRepository userRepository;

    public boolean checkUser(String email, String password){
        if(userRepository.findUser(email, password) != null)
            return true;
        else
            return false;
    }



}
