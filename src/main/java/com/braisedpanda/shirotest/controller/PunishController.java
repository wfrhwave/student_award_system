package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.Punish;
import com.braisedpanda.shirotest.bean.Reward;
import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class PunishController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;
    @Autowired
    PunishService punishService;
    @Autowired
    UserService userService;

    //添加惩罚（punish表）
    @RequestMapping("punish/addPunish")
    public String addPunish(Punish punish) {
        Date now = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String formatNow = format.format(now);
        punish.setPn_time(formatNow);
        punishService.addPunish(punish);
        return "menu/msg";
    }

    //删除Punish通过punish_id
    @RequestMapping("punish/delete/{punish_id}")
    public String deletePunish(@PathVariable("punish_id") Integer punish_id) {
        punishService.deletePunishById(punish_id);
        return "user/blank";
    }

    //查询所有punish(punish表)
    @RequestMapping("allpunish")
    @ResponseBody
    public HashMap<String, Object> allpunish(int page, int limit) {
        HashMap<String, Object> resultMap = new HashMap<>();
        List<Punish> allPunish = punishService.getAllPunish();
        int count = allPunish.size();
        PageHelper.startPage(page, limit);
        PageInfo<Punish> student_gradesPageInfo = new PageInfo<>(allPunish);
        List<Punish> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //根据punish_id查学生表和punish表并且转发到前端
    @RequestMapping("punish/toeditpunish/{punish_id}")
    public ModelAndView toeditpunish(@PathVariable("punish_id") Integer punish_id) {
        ModelAndView modelAndView = new ModelAndView();
        Punish punish = punishService.getById(punish_id);
        String stu_id = punish.getStu_id();
        Student student = studentService.getStudentById(stu_id);
        modelAndView.addObject("student", student);
        modelAndView.addObject("punish", punish);

        modelAndView.setViewName("student/editpunishstudent");
        return modelAndView;
    }

    //修改punish表
    @RequestMapping("punish/updatepunish")
    public String updatepunish(Punish punish) {
        Date now = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String formatNow = format.format(now);
        punish.setPn_time(formatNow);
        int i = punishService.updatePunish(punish);
        return "menu/msg";
    }


    //学生查看我的惩罚
    @RequestMapping("punish/mypunish")
    @ResponseBody
    public HashMap<String, Object> findMyPunish(int page, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String activecode = user.getActivecode();
        List<Punish> myPunish = punishService.getMyPunish(activecode);
        HashMap<String, Object> resultMap = new HashMap<>();
        int count = myPunish.size();
        PageHelper.startPage(page, limit);
        PageInfo<Punish> student_gradesPageInfo = new PageInfo<>(myPunish);
        List<Punish> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //老师查看我班惩罚信息
    @RequestMapping("punish/myclasspunish")
    @ResponseBody
    public HashMap<String, Object> myclasspunish(int page, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        List<String> classIdByTeacherName = classService.getClassIdByTeacherName(username);
        List<Punish> getmyclasspunish = punishService.getmyclassPunish(classIdByTeacherName);
        HashMap<String, Object> resultMap = new HashMap<>();
        int count = getmyclasspunish.size();
        PageHelper.startPage(page, limit);
        PageInfo<Punish> student_gradesPageInfo = new PageInfo<>(getmyclasspunish);
        List<Punish> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }
}
