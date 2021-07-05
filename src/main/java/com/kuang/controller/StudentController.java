package com.kuang.controller;


import com.kuang.common.http.AxiosResult;
import com.kuang.controller.base.BaseController;
import com.kuang.entity.Student;
import com.kuang.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author whl
 * @since 2021-07-02
 */
@RestController
@Api(value = "adminController", description = "学生管理")
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("list")
    @ApiOperation(value = "查询学生", notes = "查询所有学生")
    public AxiosResult<List<Student>> findAll() {
        List<Student> list = studentService.list();
        return AxiosResult.success(list);
    }

    @PostMapping("save")
    @ApiOperation(value = "添加学生", notes = "添加学生")
    public AxiosResult<Integer> save(@RequestBody Student student) {
        int save = studentService.save(student);
        return BaseController.toAxiosResult(save);
    }
    @PutMapping("update")
    @ApiOperation(value = "更新学生", notes = "更新学生")
    public AxiosResult<Integer> update(@RequestBody Student student) {
        int update = studentService.updateById(student);
        return BaseController.toAxiosResult(update);
    }
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除学生", notes = "删除学生")
    public AxiosResult<Integer> delete(@PathVariable Integer id) {
        int delete = studentService.deleteById(id);
        return BaseController.toAxiosResult(delete);
    }
    @DeleteMapping("batchdelete")
    @ApiOperation(value = "批量删除学生", notes = "批量删除学生")
    public AxiosResult<Integer> batchdelete(@RequestParam List<Serializable> idList) {
        int deleteRow = studentService.batchDeleteByIdList(idList);
        return BaseController.toAxiosResult(deleteRow);
    }
}
