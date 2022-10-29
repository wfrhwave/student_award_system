package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Reward;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */

public interface RewardService {
    int addReward(Reward reward);

    List<Reward> getAllReward();

    int deleteRewardById(Integer reward_id);

    Reward getById(Integer reward_id);

    int updateReward(Reward reward);

    List<Reward> getMyReward(String stu_id);

    List<Reward> getmyclassreward(List<String> class_ids);
}
