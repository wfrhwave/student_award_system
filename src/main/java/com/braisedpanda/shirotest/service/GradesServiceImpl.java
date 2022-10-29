package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.mapper.GradesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Component

public class GradesServiceImpl implements GradesService {
    @Autowired
    private GradesMapper gradesMapper;


    @Override
    public List<Student_Grades> getAllGrade() {
        return gradesMapper.getAllGrade();
    }

    @Override
    public List<Student_Grades> getMyGrade(String stu_id) {
        return gradesMapper.getMyGrade(stu_id);
    }


    @Override
    public void addGrades(Student_Grades student_grades) {
        gradesMapper.addGrades(student_grades);
    }

    @Override
    public List<Student_Grades> getMyClassradeByids(List<String> class_ids) {
        return gradesMapper.getMyClassradeByids(class_ids);
    }


    @Override
    public Student_Grades getOneStudentGrade(String stu_grades_id) {
        return gradesMapper.getOneStudentGrade(stu_grades_id);
    }

    @Override
    public int updateScore(Student_Grades student_grades) {
        return gradesMapper.updateScore(student_grades);
    }

    @Override
    public int deleteScoreBystu_grades_id(String stu_grades_id) {
        return gradesMapper.deleteScoreBystu_grades_id(stu_grades_id);
    }

}
