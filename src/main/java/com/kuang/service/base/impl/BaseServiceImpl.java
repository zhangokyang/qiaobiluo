package com.kuang.service.base.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.kuang.mapper.base.MyMapper;
import com.kuang.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @Author：whl
 * @Version：1.0
 * @Date：2021/7/2-16:48
 * @Since:jdk1.8
 */

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private MyMapper<T> myMapper;

    protected MyMapper<T> getMyMapper() {
        return myMapper;
    }

    @Override
    public List<T> list() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(Wrapper<T> wrapper) {
        return myMapper.selectList(wrapper);
    }

    @Override
    public T findById(Serializable id) {
        return myMapper.selectById(id);
    }

    @Override
    public int save(T t) {
        return myMapper.insert(t);
    }

    @Override
    public int updateById(T t) {
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Serializable id) {
        return myMapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIdList(List<Serializable> idList) {
        return myMapper.deleteBatchIds(idList);
    }
}
