package com.example.demo.service;

public interface UserService {
    boolean login(String userName,String password);
    String register(String phone,String userName,String password);
}
