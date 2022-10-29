package com.braisedpanda.shirotest.controller;

import com.braisedpanda.shirotest.bean.SClass;
import com.braisedpanda.shirotest.service.ClassService;
import com.braisedpanda.shirotest.service.GradesService;
import com.braisedpanda.shirotest.service.NationService;
import com.braisedpanda.shirotest.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class ClassController {
    @Autowired
    StudentService studentService;
    @Autowired
    NationService nationService;
    @Autowired
    GradesService gradesService;
    @Autowired
    ClassService classService;


    //查询所有班级
    @RequestMapping("class/all")
    @ResponseBody
    public Map<String, Object> allClass(int page, int limit) {
        int count = classService.getAllClass().size();
        PageHelper.startPage(page, limit);
        List<SClass> sClassList1 = classService.getAllClass();

        PageInfo<SClass> classPageInfo = new PageInfo<>(sClassList1);
        List<SClass> classtList = classPageInfo.getList();

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", count);
        resultMap.put("data", classtList);
        return resultMap;

    }

    //跳转界面
    @RequestMapping("toclasslist")
    public String toclasslist() {
        return "class/allclass";
    }


    //根据classid值删除class
    @ResponseBody
    @RequestMapping("class/delete/{class_id}")
    public void deleteClassById(@PathVariable("class_id") String class_id) {
        classService.deleteClassById(class_id);
    }

    //跳转到编辑班级界面
    @RequestMapping("class/toeditclass/{class_id}")
    public ModelAndView toeidtclass(@PathVariable("class_id") String class_id) {
        ModelAndView modelAndView = new ModelAndView();
        SClass sclass = classService.getClassById(class_id);
        modelAndView.addObject("class", sclass);
        modelAndView.setViewName("class/edit_class");
        return modelAndView;

    }

    //编辑班级
    @RequestMapping("editclass")
    public String editClass(SClass sClass, @NotNull Model model) {
        System.out.println(sClass);
        classService.updateClass(sClass);
        model.addAttribute("msg", "编辑班级信息成功");
        return "menu/msg";
    }


}
