package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
public class Reward implements Serializable {
    private Integer reward_id;
    private String stu_id;
    private String rw_time;
    private String reward;
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getReward_id() {
        return reward_id;
    }

    public void setReward_id(Integer reward_id) {
        this.reward_id = reward_id;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public String getRw_time() {
        return rw_time;
    }

    public void setRw_time(String rw_time) {
        this.rw_time = rw_time;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "reward_id=" + reward_id +
                ", stu_id='" + stu_id + '\'' +
                ", rw_time='" + rw_time + '\'' +
                ", reward='" + reward + '\'' +
                ", student=" + student +
                '}';
    }
}
