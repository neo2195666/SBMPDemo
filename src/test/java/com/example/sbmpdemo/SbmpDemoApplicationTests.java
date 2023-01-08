package com.example.sbmpdemo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sbmpdemo.mapper.UserMapper;
import com.example.sbmpdemo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SbmpDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void test1() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    void testAdd(){
        User user = new User();
        user.setAge(3);
        user.setName("b");
        user.setEmail("abc@gmail.com");

        int result = userMapper.insert(user);
        System.out.println(result);

    }

    @Test
    void selectTest(){
        User user =userMapper.selectById(3);
        System.out.println(user);
    }

    @Test
    void selectArray(){
        List<User> list = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(list);
    }

    @Test
    void selectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","Jack");
        map.put("id",2);
        List<User> userList = userMapper.selectByMap(map);
        System.out.println(userList);
    }

    //查询name不为空和email不为空
    @Test
    void wrapperTest1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);

        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.isNotNull("email")
                .ge("age",15);
        List<User> users1 = userMapper.selectList(wrapper1);
        System.out.println(users1);
    }

    @Test
    void wrapperTest2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name","jone");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void wrapperTest3(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("Age",5,15);
        Long aLong = userMapper.selectCount(wrapper);
        System.out.println(aLong);
    }

    @Test
    void wrapperTest4(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id","select id from mybatisplus.user where id > 20");
        List<Object> objects = userMapper.selectObjs(wrapper);
        System.out.println(objects);
    }
}
