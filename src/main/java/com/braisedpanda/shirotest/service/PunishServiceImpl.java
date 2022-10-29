package com.braisedpanda.shirotest.service;

import com.braisedpanda.shirotest.bean.Punish;
import com.braisedpanda.shirotest.mapper.PunishMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: bo
 * @date: 2022/10/13
 * @description:
 */
@Service
public class PunishServiceImpl implements PunishService {
    @Resource
    private PunishMapper mapper;

    @Override
    public int addPunish(Punish punish) {
        return mapper.addPunish(punish);
    }

    @Override
    public List<Punish> getAllPunish() {
        return mapper.getAllPunish();
    }

    @Override
    public int deletePunishById(Integer punish_id) {
        return mapper.deletePunishById(punish_id);
    }

    @Override
    public Punish getById(Integer punish_id) {
        return mapper.getById(punish_id);
    }

    @Override
    public int updatePunish(Punish punish) {
        return mapper.updatePunish(punish);
    }

    @Override
    public List<Punish> getMyPunish(String stu_id) {
        return mapper.getMyPunish(stu_id);
    }

    @Override
    public List<Punish> getmyclassPunish(List<String> class_ids) {
        return mapper.getmyclassPunish(class_ids);
    }
}
