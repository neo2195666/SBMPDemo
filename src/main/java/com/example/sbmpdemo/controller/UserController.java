package com.example.sbmpdemo.controller;


import com.alibaba.fastjson2.JSON;
import com.example.sbmpdemo.pojo.User;
import com.example.sbmpdemo.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/mpuser")
    public String user(){
        List<User> userList = userService.getUserListService();
        System.out.println("UserController => " + JSON.toJSONString(userList));

        return JSON.toJSONString(userList);
    }

}
