package com.example.sbmpdemo.services.Impl;


import com.example.sbmpdemo.mapper.UserMapper;
import com.example.sbmpdemo.pojo.User;
import com.example.sbmpdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUserListService() {
        List<User> userList = userMapper.selectList(null);
        System.out.println("UserService => " +  userList.toString());
        return userList;
    }
}
