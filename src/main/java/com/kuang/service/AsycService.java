package com.kuang.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author：zhangyang
 * @Version：1.0
 * @Date：2021/6/24-21:56
 * @desp:
 * @since:
 */
@Service
public class AsycService {
    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("数据正在处理中");
    }
}
