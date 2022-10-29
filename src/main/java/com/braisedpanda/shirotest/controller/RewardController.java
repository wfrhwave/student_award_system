package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.Reward;
import com.braisedpanda.shirotest.bean.Student;
import com.braisedpanda.shirotest.bean.Student_Grades;
import com.braisedpanda.shirotest.bean.User;
import com.braisedpanda.shirotest.mapper.RewardMapper;
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
public class RewardController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;
    @Autowired
    RewardService rewardService;
    @Autowired
    UserService userService;

    //添加Reward
    @RequestMapping("reward/addReward")
    public String addReward(Reward reward) {
        //得到当前系统时间
        Date now = new Date();
        //格式化2022-10-10
        DateFormat format = DateFormat.getDateInstance();
        String formatNow = format.format(now);
        reward.setRw_time(formatNow);
        rewardService.addReward(reward);
        return "menu/msg";
    }

    //删除Reward通过reward_id
    @RequestMapping("reward/delete/{reward_id}")
    public String deleteReward(@PathVariable("reward_id") Integer reward_id) {
        //直接删除reward表的记录
        rewardService.deleteRewardById(reward_id);
        return "user/blank";
    }

    //查询所有奖励（reward表）
    @RequestMapping("allreward")
    @ResponseBody
    public HashMap<String, Object> allreward(int page, int limit) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //学生表和reward表连接起来查询所有记录并且展示
        List<Reward> allReward = rewardService.getAllReward();
        int count = allReward.size();
        PageHelper.startPage(page, limit);
        PageInfo<Reward> student_gradesPageInfo = new PageInfo<>(allReward);
        List<Reward> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //根据reward_id查学生表和reward表并且转发到前端修改奖励学生列表页面
    @RequestMapping("reward/toeditreward/{reward_id}")
    public ModelAndView toeditreward(@PathVariable("reward_id") Integer reward_id) {
        ModelAndView modelAndView = new ModelAndView();
        //根据reward_id查reard表得到信息
        Reward reward = rewardService.getById(reward_id);
        //通过reard得到学生的学号
        String stu_id = reward.getStu_id();
        //通过学号拿到学生信息
        Student student = studentService.getStudentById(stu_id);
        //转发到前端
        modelAndView.addObject("student", student);
        modelAndView.addObject("reward", reward);
        modelAndView.setViewName("student/editrewardstudent");
        return modelAndView;
    }

    //修改reward表
    @RequestMapping("reward/updatereward")
    public String updatereward(Reward reward) {
        Date now = new Date();
        DateFormat format = DateFormat.getDateInstance();
        String formatNow = format.format(now);
        reward.setRw_time(formatNow);
        int i = rewardService.updateReward(reward);
        return "menu/msg";
    }


    //学生查看我的奖励
    @RequestMapping("reward/myreward")
    @ResponseBody
    public HashMap<String, Object> findMyReward(int page, int limit, HttpSession session) {
        //从session域拿到登录者的信息
        User user = (User) session.getAttribute("user");
        //学生用户拿到自己的学号
        String activecode = user.getActivecode();
        //根据学号查reward表
        List<Reward> myReward = rewardService.getMyReward(activecode);
        HashMap<String, Object> resultMap = new HashMap<>();
        int count = myReward.size();
        PageHelper.startPage(page, limit);
        PageInfo<Reward> student_gradesPageInfo = new PageInfo<>(myReward);
        List<Reward> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }

    //老师查看我班奖励信息
    @RequestMapping("reward/myclassreward")
    @ResponseBody
    public HashMap<String, Object> myclassreward(int page, int limit, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //拿到老师用户的名字
        String username = user.getUsername();
        //根据名字去班级表class查到此老师所带的所有班级
        List<String> classIdByTeacherName = classService.getClassIdByTeacherName(username);
        //把学生表和reward表连接然后通过班级查询该班级所有学生的reward信息
        List<Reward> getmyclassreward = rewardService.getmyclassreward(classIdByTeacherName);
        HashMap<String, Object> resultMap = new HashMap<>();
        int count = getmyclassreward.size();
        PageHelper.startPage(page, limit);
        PageInfo<Reward> student_gradesPageInfo = new PageInfo<>(getmyclassreward);
        List<Reward> list = student_gradesPageInfo.getList();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", list);
        return resultMap;
    }
}
