package com.kuang.service.impl;

import com.kuang.entity.Student;
import com.kuang.service.StudentService;
import com.kuang.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whl
 * @since 2021-07-02
 */
@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

}
