package com.braisedpanda.shirotest.controller;


import com.braisedpanda.shirotest.bean.Student_Grades;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.GradesService;
import com.braisedpanda.shirotest.service.NationService;
import com.braisedpanda.shirotest.service.StudentService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GradesController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;


    //查询我的成绩（学生自己）
    @ResponseBody
    @RequestMapping("grades/mystudent/{stu_id}")
    public Map<String, Object> getStudentMyGrades(@PathVariable("stu_id") String stu_id, int page, int limit) {
        //通过学号查成绩（student表和student_grades表连接；左连接学生表，保证存在的学生的一定有成绩）
        List<Student_Grades> myGrade = gradesService.getMyGrade(stu_id);
        int count = myGrade.size();
        PageHelper.startPage(page, limit);
        PageInfo<Student_Grades> studentGradesPageInfo = new PageInfo<>(myGrade);
        List<Student_Grades> studentGradesList = studentGradesPageInfo.getList();
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", studentGradesList);
        return resultMap;
    }

    //跳转到我的成绩页面
    @RequestMapping("tostudentgrades")
    public String tostudentgrades(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //拿到学号
        String stu_id = user.getActivecode();
        System.out.println(user);
        model.addAttribute("stu_id", stu_id);
        return "student/studentgrades";
    }


    //我班成绩
    @ResponseBody
    @RequestMapping("classgrades")
    public HashMap<String, Object> classgrades(int page, int limit, HttpSession session) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //拿到教师用户的名字
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        //通过名字查class表拿到所有班主任为此教师的班级
        List<String> classIdByTeacherName = classService.getClassIdByTeacherName(username);
        //通过班级查（student_grades表与student表连接起来）
        List<Student_Grades> myClassradeByids = gradesService.getMyClassradeByids(classIdByTeacherName);
        int count = myClassradeByids.size();
        PageHelper.startPage(page, limit);
        PageInfo<Student_Grades> student_gradesPageInfo = new PageInfo<>(myClassradeByids);
        List<Student_Grades> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //所有成绩
    @ResponseBody
    @RequestMapping("allclassgrades")
    public HashMap<String, Object> allclassgrades(int page, int limit) {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<Student_Grades> allGrade = gradesService.getAllGrade();
        int count = allGrade.size();
        //页码值，每页条数
        PageHelper.startPage(page, limit);
        PageInfo<Student_Grades> student_gradesPageInfo = new PageInfo<>(allGrade);
        List<Student_Grades> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //根据stu_grades_id查找单个学生成绩，并返回到editstudentscore界面
    @RequestMapping("student/toeditstudentclass/{stu_grades_id}")
    public ModelAndView toeditstudent(@PathVariable("stu_grades_id") String stu_grades_id) {
        ModelAndView modelAndView = new ModelAndView();
        //把student表和student_grades表连起来
        Student_Grades oneStudentGrade = gradesService.getOneStudentGrade(stu_grades_id);
        modelAndView.addObject("myGrade", oneStudentGrade);
        modelAndView.setViewName("student/editstudentscore");
        return modelAndView;
    }


    //根据stu_grades_id修改学生成绩
    @RequestMapping("student/updatestudentscore")
    public String updatestudentscore(Student_Grades student_grades) {
        //动态sql，保证前端传递来的为空的也不会把数据更新为空
        gradesService.updateScore(student_grades);
        return "menu/msg";
    }

    //根据stu_grades_id删除学生成绩
    @RequestMapping("student/deletestudentscore/{stu_grades_id}")
    public String deletestudentscore(@PathVariable("stu_grades_id") String stu_grades_id) {
        gradesService.deleteScoreBystu_grades_id(stu_grades_id);
        return "menu/msg";
    }

}
