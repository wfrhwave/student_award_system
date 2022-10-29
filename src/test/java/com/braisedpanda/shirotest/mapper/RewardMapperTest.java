package com.braisedpanda.shirotest.mapper;

import com.braisedpanda.shirotest.bean.Reward;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/12
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RewardMapperTest {
    @Resource
    private RewardMapper rewardMapper;
    @Test
    public void test1() {
        List<Reward> allReward = rewardMapper.getAllReward();
        for (Reward reward : allReward) {
            System.out.println(reward);

        }
    }
}
