package com.example.demo.service;

import com.example.demo.bean.User;

import java.util.List;

public interface UserService {
    boolean login(String userName,String password);
    boolean adminLogin(String userName,String password);
    String register(String phone,String userName,String password);
    String changePassword(String phone,String userName,String password);
    List<User> findAllUser(boolean isAdmin);
    boolean deleteById(int uid);
    User findByAccount(String userName);
    User findById(int uid);
}
