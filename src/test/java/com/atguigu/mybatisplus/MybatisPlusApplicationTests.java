package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.entity.User;
import com.atguigu.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    void findAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        System.out.println(users);
    }

    @Test
    void insert(){
        //mybatisplus自动生成19位的主键
        User user =new User();
        user.setName("李子恩");
        user.setAge(120);
        user.setEmail("lizien_ywxk@163.com");
        int i = userMapper.insert(user);
        System.out.println("insert:"+i);
    }

    @Test
    void updateById(){
        User user =new User();
        user.setId(1317398790260441089L);
        user.setAge(100);
        userMapper.updateById(user);
    }

    @Test
    void testOptimisticLocker(){
        User user = userMapper.selectById(1317416305254584321L);
        user.setAge(102);
        user.setVersion(user.getVersion()-1);
        userMapper.updateById(user);
    }

}
