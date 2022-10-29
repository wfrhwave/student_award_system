package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface GradesService {

    List<Student_Grades> getAllGrade();

    List<Student_Grades> getMyGrade(String stu_id);

    @CacheEvict(value = "grades", allEntries = true, key = "'addGrades:'+#student_grades.stu_grades_id")
    void addGrades(Student_Grades student_grades);

    //根据class_id获得学生成绩
    List<Student_Grades> getMyClassradeByids(List<String> class_ids);

    Student_Grades getOneStudentGrade(String stu_grades_id);

    int updateScore(Student_Grades student_grades);

    int deleteScoreBystu_grades_id(String stu_grades_id);

}
