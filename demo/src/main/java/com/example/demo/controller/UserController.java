package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public boolean login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password){
        return userService.login(userName, password);
    }

    @RequestMapping(value = "/AdminLogin",method = RequestMethod.GET)
    public boolean adminLogin(@RequestParam("userName") String userName,
                         @RequestParam("password") String password){
        return userService.adminLogin(userName, password);
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(@RequestParam("phone") String phone,
                           @RequestParam("userName") String userName,
                           @RequestParam("password") String password){
        return userService.register(phone, userName, password);
    }

    @RequestMapping(value = "/changePassword",method = RequestMethod.GET)
    public String changePassword(@RequestParam("phone") String phone,
                           @RequestParam("userName") String userName,
                           @RequestParam("password") String password){
        return userService.changePassword(phone, userName, password);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public List<User> findAll(@RequestParam("isAdmin") boolean isAdmin){
        return userService.findAllUser(isAdmin);
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public boolean delete(@RequestParam("uid") int uid){
        return userService.deleteById(uid);}

    @RequestMapping(value = "findById",method = RequestMethod.GET)
    public User findById(@RequestParam("uid") int uid){
        return userService.findById(uid);}

    @RequestMapping(value = "findByAccount",method = RequestMethod.GET)
    public User findByAccount(@RequestParam("userName") String userName){
        return userService.findByAccount(userName);
    }
}
