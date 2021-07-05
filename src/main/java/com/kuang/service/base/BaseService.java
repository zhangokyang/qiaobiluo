package com.kuang.service.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/7/2-16:45
 * @Since:jdk1.8
 */
public interface BaseService<T>{
    /**
     * 查询所有
     * @return
     */
    List<T> list();

    /**
     * 按条件查询
     * @param wrapper
     * @return
     */
    List<T> search(Wrapper<T> wrapper);

    /**
     * 按id进行查询
     * @param id
     * @return
     */
    T findById(Serializable id);

    /**
     * 保存操作
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 按id进行更新
     * @param t
     * @return
     */
    int updateById(T t);

    /**
     * 按id删除
     * @param id
     * @return
     */
    int deleteById(Serializable id);

    /**
     * 按idList批量删除
     * @param idList
     * @return
     */
    int batchDeleteByIdList(List<Serializable> idList);
}
