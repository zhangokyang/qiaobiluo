package com.kuang.controller;

import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/22-23:17
 * @desp:
 * @since:
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("queryUserList")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        return users;
    }
}
