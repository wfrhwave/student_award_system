package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GradesMapper {


    List<Student_Grades> getMyGrade(@Param("stu_id") String stu_id);

    List<Student_Grades> getAllGrade();

    //根据class_id获得学生成绩
    List<Student_Grades> getMyClassradeByids(List<String> class_ids);

    void addGrades(Student_Grades student_grades);

    //根据stu_grades_id获得单个学生成绩
    Student_Grades getOneStudentGrade(String stu_grades_id);

    int updateScore(Student_Grades student_grades);

    int deleteScoreBystu_grades_id(String stu_grades_id);


}
