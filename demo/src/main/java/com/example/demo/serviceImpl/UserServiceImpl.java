package com.example.demo.serviceImpl;

import com.example.demo.bean.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean login(String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        return !userMapper.selectByExample(userExample).isEmpty();   //查询结果为空则返回false
    }
}
