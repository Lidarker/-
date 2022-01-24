package com.example.demo.mapper;

import com.example.demo.bean.UserBean;
import org.springframework.stereotype.Repository;

public interface UserMapper {
    UserBean getInfo(String name,String password);
}
