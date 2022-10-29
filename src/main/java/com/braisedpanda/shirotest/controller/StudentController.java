package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.*;
import com.braisedpanda.shirotest.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    UserService userService;
    @Autowired
    PermissionService permissionService;
    @Autowired
    ClassService classService;


    //查询所有学生
    @RequestMapping("student/all")
    @ResponseBody
    public Map<String, Object> allStudent(int page, int limit) {

        int count = studentService.getAllStudent().size();
        PageHelper.startPage(page, limit);
        //查询所有学生
        List<Student> studentList1 = studentService.getAllStudent();
        PageInfo<Student> studentPageInfo = new PageInfo<>(studentList1);
        List<Student> studentList = studentPageInfo.getList();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", studentList);
        return resultMap;
    }

    //查询学生通过班级查
    @RequestMapping("student/mystudent")
    @ResponseBody
    public Map<String, Object> myStudent(int page, int limit, HttpSession session) {
        //从session域拿到用户信息
        User user = (User) session.getAttribute("user");
        //拿到老师的名字
        String username = user.getUsername();
        //通过名字查class表拿到此老师带的班的所有班级
        List<String> classIdByTeacherName = classService.getClassIdByTeacherName(username);
        //通过班级查学生表
        List<Student> classByIds = studentService.getClassByIds(classIdByTeacherName);
        int count = classByIds.size();
        PageHelper.startPage(page, limit);

        PageInfo<Student> studentPageInfo = new PageInfo<>(classByIds);
        List<Student> studentList = studentPageInfo.getList();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", studentList);
        return resultMap;
    }

    @RequestMapping("student/myInfo/{stu_id}")
    public ModelAndView lookMyInfo(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        Student user = (Student) session.getAttribute("user");
        Student student = studentService.getStudentById(user.getStu_id());
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student/editstudent");
        return modelAndView;
    }

    // todo
    //跳转到我的信息
    @RequestMapping("tostudentinfo")
    Map<String, Object> tostudentinfo(int page, int limit) {
        int count = studentService.getAllStudent().size();
        PageHelper.startPage(page, limit);
        Student studentById = studentService.getStudentById("20180002231");
        List<Student> list = new ArrayList<>();
        list.add(studentById);
        PageInfo<Student> studentPageInfo = new PageInfo<>(list);
        List<Student> studentList = studentPageInfo.getList();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", studentList);
        return resultMap;
    }


    //删除学生信息
    @RequestMapping("student/delete/{stu_id}")
    public String delete(@PathVariable("stu_id") String stu_id) {
        studentService.delete(stu_id);
        return "user/blank";
    }


    //更新学生信息
    @RequestMapping("/editstudent")
    public String editstudent(Student student) {
        studentService.updateStudent(student);
        return "student/allstudent";
    }

    //根据stu_id查找学生信息，并返回到界面
    @RequestMapping("student/toeditstudent/{stu_id}")
    public ModelAndView toeditstudent(@PathVariable("stu_id") String stu_id) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(stu_id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student/editstudent");
        return modelAndView;
    }


    //根据stu_id查找reward表，并返回到界面
    @RequestMapping("student/torewardstudent/{stu_id}")
    public ModelAndView torewardstudent(@PathVariable("stu_id") String stu_id) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(stu_id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student/addrewardstudent");
        return modelAndView;
    }

    //根据stu_id查找punish表，并返回到界面
    @RequestMapping("student/topunishstudent/{stu_id}")
    public ModelAndView topunishstudent(@PathVariable("stu_id") String stu_id) {
        ModelAndView modelAndView = new ModelAndView();
        Student student = studentService.getStudentById(stu_id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student/addpunishstudent");
        return modelAndView;
    }

    //查询nation表和班级表跳转到添加学生界面
    @RequestMapping("toaddstudent")
    public String tostudent(Model model) {
        //查询nation表
        List<Nation> nationList = nationService.getAllNation();
        model.addAttribute("nationList", nationList);
        //查询班级表
        List<SClass> classList = classService.getAllClass();
        model.addAttribute("classList", classList);
        return "student/addstudent";
    }

    //查询所有学生并且跳转到上传学生成绩界面
    @RequestMapping("toaddstudentscore")
    public String tostudentscore(Model model) {
        List<Student> allStudent = studentService.getAllStudent();
        model.addAttribute("allStudents", allStudent);
        return "student/addstudentscore";
    }

    //添加学生信息
    @RequestMapping("student/addstudent")
    public String addstudent(Student student) {
        //注册学生信息
        String stu_id = UUID.randomUUID() + "";
        stu_id = stu_id.replace("-", "");
        stu_id = stu_id.substring(0, 11);
        student.setStu_id(stu_id);
        studentService.addStudent(student);
        //注册学生信息时,自动注册用户信息
        User user = new User();
        user.setUsername(student.getStu_name());
        user.setPassword(student.getStu_password());
        user.setEmail(student.getStu_email());
        user.setBirthday(student.getStu_birthday());
        user.setGender(student.getStu_sex());
        user.setActivecode(stu_id);
        userService.addUser(user);
        //授予该学生权限
        User_Role user_role = new User_Role();
        user_role.setUid(user.getUid());
        user_role.setU_r_id(stu_id);
        user_role.setUsername(student.getStu_name());
        user_role.setRoleid("3");
        user_role.setRole("学生");
        user_role.setRole_describe("学生权限");
        permissionService.addUser_Role(user_role);
        return "menu/msg";

    }

    //拿到前端传来的数据上传学生成绩
    @RequestMapping("student/addstudentscore")
    public String addstudentscore(Student_Grades grades) {
        //调试时候写的
        System.out.println(grades);
        //设置stu_grades_id
        String  stu_grades_id= UUID.randomUUID() + "";
        stu_grades_id = stu_grades_id.replace("-", "");
        stu_grades_id = stu_grades_id.substring(0, 12);
        grades.setStu_grades_id("SGISGC" + stu_grades_id);
        gradesService.addGrades(grades);
        return "menu/msg";

    }
}
