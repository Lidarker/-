package com.example.demo.serviceImpl;

import com.example.demo.bean.User;
import com.example.demo.bean.UserExample;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public boolean adminLogin(String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(userName);
        criteria.andPasswordEqualTo(password);
        criteria.andIsadminEqualTo(true);
        return !userMapper.selectByExample(userExample).isEmpty();
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

    @Override
    public String changePassword(String phone, String userName, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(userName);
        criteria.andPhoneEqualTo(phone);
        if (userMapper.selectByExample(userExample).size()==1){
            User user = new User();
            user.setPassword(password);
            if (userMapper.updateByExampleSelective(user,userExample)==1){
                return "修改成功";
            }else {
                return "异常错误";
            }
        }else {
            return "账号或电话号码错误";
        }
    }

    @Override
    public List<User> findAllUser(boolean isAdmin) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIsadminEqualTo(isAdmin);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public boolean deleteById(int uid) {
        return userMapper.deleteByPrimaryKey(uid)==1;
    }

    @Override
    public User findByAccount(String userName) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andAccountEqualTo(userName);
        return userMapper.selectByExample(userExample).get(0);
    }

    @Override
    public User findById(int uid) {
        return userMapper.selectByPrimaryKey(uid);
    }

}
