package com.kuang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/22-9:28
 * @desp:
 * @since:
 */
@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("list")
    public List<Map<String,Object>> userList(){
        String sql="select * from student";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }
    @RequestMapping("add")
    public String addUser(){
        String sql="insert into student values(null,'张三','男',1994,'英语系','武汉')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }
    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql="update student set name=?,sex=? where sid="+id;
        Object[] objects = new Object[2];
        objects[0]="张洋";
        objects[1]="z";
        jdbcTemplate.update(sql,objects);
        return "update-okkkkk";
    }

}
