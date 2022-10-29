package com.braisedpanda.shirotest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {

    @RequestMapping("toregist")
    public String toregist() {
        return "user/regist";
    }

    @RequestMapping("tologin")
    public String tologin() {
        return "index";
    }

    @RequestMapping("jump")
    public String tojump() {
        return "test/jump";
    }

    @RequestMapping("index")
    public String index() {
        return "menu/main";
    }

    @RequestMapping("uploadtest")
    public String upload() {
        return "user/upload";
    }


    @RequestMapping("notRole")
    public String testr() {
        return "menu/nopermission";
    }
    //跳转到所有学生列表
    @RequestMapping("tostudentlist")
    public String tostudentlist() {
        return "student/allstudent";
    }
    //跳转到学生奖惩列表页面
    @RequestMapping("torewardstudentlist")
    public String torewardstudentlist() {
        return "student/allrewardstudent";
    }
    //跳转到我班学生展示页面
    @RequestMapping("tomystudent")
    public String tomystudent() {
        return "student/mystudent";
    }


    @RequestMapping("toallpermission")
    public String toallpermission() {
        return "permission/allrole_permission";
    }
    //跳转到我的奖励页面
    @RequestMapping("tomyreward")
    public String tomyreward() {
        return "student/myreward";
    }
    //跳转到我的惩罚页面
    @RequestMapping("tomypunish")
    public String tomypunish() {
        return "student/mypunish";
    }
    //跳转到我班奖励页面
    @RequestMapping("tomyclassreward")
    public String tomyclassreward() {
        return "student/myclassreward";
    }
    //跳转到我班惩罚页面
    @RequestMapping("tomyclasspunish")
    public String tomyclasspunish() {
        return "student/myclasspunish";
    }

    @RequestMapping("toleft")
    public String toleft() {
        return "menu/left";
    }

    @RequestMapping("toallrole")
    public String toallrole() {
        return "permission/allrole";
    }

    //跳转到我班成绩
    @RequestMapping("toclassgrades")
    public String toclassgrades() {
        return "class/classgrades";
    }
    //跳转到奖励发布信息页面
    @RequestMapping("torewardlist")
    public String torewardlist() {
        return "student/allreward";
    }
    //跳转到惩罚发布信息页面
    @RequestMapping("topunishlist")
    public String topunishlist() {
        return "student/allpunish";
    }
    //跳转到查询所有学生成绩页面
    @RequestMapping("toallclassgrades")
    public String toallclassgrades() {
        return "class/allclassgrades";
    }

    @RequestMapping("toupdaestudent")
    public String toupdaestudent() {
        return "class/classgrades";
    }

}
