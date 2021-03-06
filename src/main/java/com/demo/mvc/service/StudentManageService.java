package com.demo.mvc.service;

import com.demo.mvc.MapperInterface.StudentEntityMapper;
import com.demo.mvc.model.StudentEntity;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by XYY78 on 2016/9/1.
 */

@Service
public class StudentManageService {

    @Autowired
    public SqlSessionFactory sqlSessionFactory;

    @Autowired
    public StudentEntityMapper studentManageDao;

    // query all studentEntity without query condition
    public List<StudentEntity> getStudents() {
        return studentManageDao.queryStudentList();
    }

    // query stduentEntity by id
    public StudentEntity getStudentById(Long id) {
        return studentManageDao.queryStudentById(id);
    }

    // query studentEntitys by ids
    public List<StudentEntity> queryStudentList(List<Long> idList) {
        return studentManageDao.queryStudentByIdList(idList);
    }

    // update by studentId
    public int updateStudentInfoById(StudentEntity studentEntity) {
        return studentManageDao.updateStudentEntityById(studentEntity);
    }

    // batch add studentEntity
    public int addStudentEntityList(List<StudentEntity> entityList){
       return studentManageDao.addStudentEntityList(entityList);
    }

    public int addStudent(StudentEntity studentEntity){
        if(studentEntity == null || StringUtils.isEmpty(studentEntity.getStudentName())) {
            return 0;
        }
        return studentManageDao.addStudentEntity(studentEntity);
    }
    // batch add StduentEntityList using sqlSession
    public int addStudentEntityListUseingSqlSession(List<StudentEntity> entityList) throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
        int result =0 ;
        try{
            for (StudentEntity stu: entityList
                 ) {
                sqlSession.insert("com.springapp.mvc.businessModelMapper.mysqlMapper.StudentEntityMapper.addStudentEntity",stu);
            }
            sqlSession.commit();
        }  finally {
            if(sqlSession !=null){
                sqlSession.close();
            }
        }
        return result;
    }

    public void deleteStudentList(String idList){
        if(StringUtils.isEmpty(idList)) {
            return;
        }
        List<String> stringList = Arrays.asList(idList.split(","));
        studentManageDao.deleteStudentsByIdList(stringList);
    }
}
