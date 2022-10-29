package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.StudentService;
import com.braisedpanda.shirotest.service.UserService;
import junit.framework.TestCase;
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
 * @date: 2022/10/6
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentMapperTest extends TestCase {
    @Resource
    private StudentService studentService;





    @Test
    public void testGetStudentByClassId() {
        List<String> list = new ArrayList<>(Arrays.asList("G006", "G203", "G208"));

        List<Student> id = studentService.getClassByIds(list);
        System.out.println(id);
    }
}