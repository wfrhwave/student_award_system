package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.ShirotestApplication;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.UserService;
import junit.framework.TestCase;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author: bo
 * @date: 2022/10/6
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest extends TestCase {
    @Resource
    private UserService service;
    @Resource
    private ClassService classService;

    @Test
    public void testGetUser() {
        User admin = service.getUser("student", "123");
        User user = new User();
        user.setUid(0);
        user.setUsername("");
        user.setPassword("");
        user.setEmail("");
        user.setBirthday("");
        user.setGender("");
        user.setActivecode("");
        user.setImages("");
        user.setRoleId("");

        System.out.println(admin);
    }

    @Test
    public void toGetClassIdByUserName() {
        List<String> id = classService.getClassIdByTeacherName("马良");
        User user = new User();
        user.setUid(0);
        user.setUsername("");
        user.setPassword("");
        user.setEmail("");
        user.setBirthday("");
        user.setGender("");
        user.setActivecode("");
        user.setImages("");
        user.setRoleId("");
        System.out.println(id.toString());
    }


    @Test
    public void test() {
        // 提取张三 去除数字
        User user = new User();
        user.setUid(0);
        user.setUsername("");
        user.setPassword("");
        user.setEmail("");
        user.setBirthday("");
        user.setGender("");
        user.setActivecode("");
        user.setImages("");
        user.setRoleId("");
        String r_name3 = "张三 13599998888 000000";
        Pattern pattern = Pattern.compile("[\\d]");
        Matcher matcher = pattern.matcher(r_name3);
        System.out.println(matcher.replaceAll("").trim());
    }

}