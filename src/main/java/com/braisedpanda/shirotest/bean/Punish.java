package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
public class Punish implements Serializable {
    private Integer punish_id;
    private String stu_id;
    private String pn_time;
    private String punish;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getPunish_id() {
        return punish_id;
    }

    public void setPunish_id(Integer punish_id) {
        this.punish_id = punish_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getPn_time() {
        return pn_time;
    }

    public void setPn_time(String pn_time) {
        this.pn_time = pn_time;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    @Override
    public String toString() {
        return "Punish{" +
                "punish_id=" + punish_id +
                ", stu_id='" + stu_id + '\'' +
                ", pn_time='" + pn_time + '\'' +
                ", punish='" + punish + '\'' +
                ", student=" + student +
                '}';
    }
}
