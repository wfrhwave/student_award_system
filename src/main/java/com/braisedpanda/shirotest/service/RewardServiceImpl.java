package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Reward;
import com.braisedpanda.shirotest.mapper.RewardMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
@Component
public class RewardServiceImpl implements RewardService {
    @Resource
    private RewardMapper rewardMapper;

    @Override
    public int addReward(Reward reward) {
        return rewardMapper.addReward(reward);
    }

    @Override
    public List<Reward> getAllReward() {
        return rewardMapper.getAllReward();
    }

    @Override
    public int deleteRewardById(Integer reward_id) {
        return rewardMapper.deleteRewardById(reward_id);
    }

    @Override
    public Reward getById(Integer reward_id) {
        return rewardMapper.getById(reward_id);
    }

    @Override
    public int updateReward(Reward reward) {
        return rewardMapper.updateReward(reward);
    }

    @Override
    public List<Reward> getMyReward(String stu_id) {
        return rewardMapper.getMyReward(stu_id);
    }

    @Override
    public List<Reward> getmyclassreward(List<String> class_ids) {
        return rewardMapper.getmyclassreward(class_ids);
    }
}
