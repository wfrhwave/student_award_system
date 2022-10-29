package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.SClass;
import com.braisedpanda.shirotest.bean.Student;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ClassService {

    @CacheEvict(value = "class", key = "'addClass:'+#sclass.class_id", allEntries = true)
    void addClass(SClass sclass);

    List<SClass> getAllClass();

    //根据classid值删除class
    @CacheEvict(value = "class", key = "'deleteClassById:'+#class_id")
    void deleteClassById(String class_id);

    //根据class_id查找对应的class

    SClass getClassById(String class_id);

    //根据class_teacher查找对应的class_id
    @Cacheable(value = "class", key = "'getClassIdByTeacherName:'+#class_teacher")
    List<String> getClassIdByTeacherName(String class_teacher);

    //更新班级信息
    @CacheEvict(value = "class", key = "'updateClass:'+#sClass.class_id")
    void updateClass(SClass sClass);

    //获取所有的班级id
    @Cacheable(value = "class")
    List<String> getAllClassId();
}
