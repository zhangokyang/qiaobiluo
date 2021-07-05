package com.kuang.controller.base;

import com.kuang.common.http.AxiosResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/7/3-10:33
 * @Since:jdk1.8
 */
@RestController
public class BaseController {

    public static AxiosResult<Integer> toAxiosResult(int row){
        return row > 0 ?  AxiosResult.success(row):AxiosResult.error(row);
    }
}
