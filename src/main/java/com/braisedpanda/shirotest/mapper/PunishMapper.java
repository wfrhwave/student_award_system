package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Punish;
import com.braisedpanda.shirotest.bean.Punish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
@Mapper
public interface PunishMapper {
    int addPunish(Punish punish);

    List<Punish> getAllPunish();

    int deletePunishById(Integer punish_id);

    Punish getById(Integer punish_id);

    int updatePunish(Punish punish);

    List<Punish> getMyPunish(@Param("stu_id") String stu_id);

    List<Punish> getmyclassPunish(List<String> class_ids);

}
