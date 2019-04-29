package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.CheckLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CheckLogin checkLogin;

    @RequestMapping("/ciao")
    @ResponseBody
    public String sayHello(){
        return "ciao";
    }


    @RequestMapping("")
    public String home(){
        return "benvenuto nella home";
    }

    @RequestMapping("/loginHomePage/{email}/{password}")
    @ResponseBody
    public User loginToHomePage(@PathVariable("email") String email, @PathVariable("password") String password){



        /*return userRepository.findAllUsers();*/
        return userRepository.findUser(email, password);


        /*if(checkLogin.checkUser(email, password))     //prova di utilizzo della @Service(finito male)
            return "true";

        else return "false";*/
    }
    @RequestMapping("/loginBoolean/{email}/{password}")
    @ResponseBody
    public boolean loginToHomePageBoolean(@PathVariable("email") String email, @PathVariable("password") String password){
    if(userRepository.findUser(email, password) != null)
            return true;
        else
                return false;
    }






}
