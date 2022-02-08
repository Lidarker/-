package com.example.demo.serviceImpl;

import com.example.demo.bean.User;
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

    @Override
    public String register(String phone, String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(userName);
        //不允许用户名相同，抢占制度
        if(userMapper.selectByExample(userExample).isEmpty()){
            User user = new User();
            user.setPhone(phone);
            user.setAccount(userName);
            user.setPassword(password);
            if(userMapper.insertSelective(user)==1){
                return "注册成功";
            }else {
                return "注册失败";
            }
        }else {
            return "该用户名已被使用";
        }
    }
}
