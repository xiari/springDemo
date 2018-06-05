package com.demo.mvc.MapperInterface;

import com.demo.mvc.model.StudentEntity;

import java.util.List;

/**
 * Created by XYY78 on 2016/9/1.
 */

public interface StudentEntityMapper {

    /**
     * 全量查询，不含条件
     * @return
     */
    List<StudentEntity> queryStudentList();

    /**
     * 根据主键ID查询
     * @param id
     * @return
     */
    StudentEntity queryStudentById(Long id);
    /**
     * 批量查询
     * @param ids
     * @return
     */
    List<StudentEntity> queryStudentByIdList(List<Long> ids);

     /**
     * 批量增加学生
     * @param studentEntities
     */
    int addStudentEntityList(List<StudentEntity> studentEntities);


    /**
     * 批量增加学生
     * @param studentEntity
     */
    int addStudentEntity(StudentEntity studentEntity);

    /**
     * 根据学生id批量更新学生信息
     * @param studentEntity
     */
    int updateStudentEntityById(StudentEntity studentEntity);

    /**
     * 批量删除
     * @param studentIdList
     * @return
     */
    void deleteStudentsByIdList(List<String> studentIdList);
}
