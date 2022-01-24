package com.example.demo.service;

import com.example.demo.bean.UserBean;

public interface UserService {
    UserBean loginIn(String name,String password);
}
