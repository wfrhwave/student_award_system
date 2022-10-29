package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Punish;
import com.braisedpanda.shirotest.bean.Reward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */

public interface PunishService {
    int addPunish(Punish punish);

    List<Punish> getAllPunish();

    int deletePunishById(Integer punish_id);

    Punish getById(Integer punish_id);

    int updatePunish(Punish punish);

    List<Punish> getMyPunish(String stu_id);

    List<Punish> getmyclassPunish(List<String> class_ids);
}
