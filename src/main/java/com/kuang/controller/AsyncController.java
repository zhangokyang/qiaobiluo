package com.kuang.controller;


import com.kuang.service.AsycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/24-21:58
 * @desp:
 * @since:
 */
@RestController
public class AsyncController {
    @Autowired
    AsycService asycService;
    @RequestMapping("/gg")
    public String hello(){
asycService.hello();
return "ok";
    }
}
