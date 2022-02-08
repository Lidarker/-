package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public boolean login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password){
        return userService.login(userName, password);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(@RequestParam("phone") String phone,
                           @RequestParam("userName") String userName,
                           @RequestParam("password") String password){
        return userService.register(phone, userName, password);
    }

}
