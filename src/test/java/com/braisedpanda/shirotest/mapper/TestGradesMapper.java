package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Student_Grades;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/9
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestGradesMapper {
    @Resource
    private GradesMapper gradesMapper;

    @Test
    public void testGetMyGrade() {
        List<Student_Grades> myGrade = gradesMapper.getMyGrade("20185006175");
        Student_Grades student_grades1 = new Student_Grades();
        student_grades1.setStu_grades_id("");
        student_grades1.setStu_name("");
        student_grades1.setStu_id("");
        student_grades1.setClass_id("");
        student_grades1.setTest_describe("");
        student_grades1.setChinese(0.0D);
        student_grades1.setMathematics(0.0D);
        student_grades1.setEnglish(0.0D);
        student_grades1.setPolitics(0.0D);
        student_grades1.setHistory(0.0D);
        student_grades1.setGeography(0.0D);
        student_grades1.setBiology(0.0D);
        student_grades1.setChemistry(0.0D);
        student_grades1.setPhysics(0.0D);
        student_grades1.setMusic(0.0D);
        student_grades1.setArts(0.0D);
        student_grades1.setSports(0.0D);
        for (Student_Grades student_grades : myGrade) {


            System.out.println(student_grades);
        }
    }



    @Test
    public void testGetMyClassradeByids() {
        List<String> list = new ArrayList<>(Arrays.asList("G006", "G203", "G208"));
        Student_Grades student_grades1 = new Student_Grades();
        student_grades1.setStu_grades_id("");
        student_grades1.setStu_name("");
        student_grades1.setStu_id("");
        student_grades1.setClass_id("");
        student_grades1.setTest_describe("");
        student_grades1.setChinese(0.0D);
        student_grades1.setMathematics(0.0D);
        student_grades1.setEnglish(0.0D);
        student_grades1.setPolitics(0.0D);
        student_grades1.setHistory(0.0D);
        student_grades1.setGeography(0.0D);
        student_grades1.setBiology(0.0D);
        student_grades1.setChemistry(0.0D);
        student_grades1.setPhysics(0.0D);
        student_grades1.setMusic(0.0D);
        student_grades1.setArts(0.0D);
        student_grades1.setSports(0.0D);
        List<Student_Grades> myClassradeByids = gradesMapper.getMyClassradeByids(list);
        for (Student_Grades myClassradeByid : myClassradeByids) {
            System.out.println(myClassradeByid);
        }
    }


}
