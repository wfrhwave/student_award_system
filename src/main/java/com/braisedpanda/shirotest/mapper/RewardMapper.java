package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Reward;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
@Mapper
public interface RewardMapper {
    int addReward(Reward reward);

    List<Reward> getAllReward();

    int deleteRewardById(Integer reward_id);

    Reward getById(Integer reward_id);

    int updateReward(Reward reward);

    List<Reward> getMyReward(@Param("stu_id") String stu_id);

    List<Reward> getmyclassreward(List<String> class_ids);

}
