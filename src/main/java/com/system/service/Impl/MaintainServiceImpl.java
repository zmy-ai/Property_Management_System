package com.system.service.Impl;

import com.system.mapper.MaintainMapper;
import com.system.pojo.Maintain;
import com.system.service.MaintainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintainServiceImpl implements MaintainService {
    @Autowired
    private MaintainMapper maintainMapper;
    @Override
    public List<Maintain> selectAll() {
        List<Maintain> maintains = maintainMapper.selectAll();
        return maintains;
    }

    @Override
    public Integer insertUser_maintain(Maintain maintain) {
        Integer integer = maintainMapper.insertUser_maintain(maintain);
        return integer;
    }

    @Override
    public Maintain selectMaintainByid(Integer id) {
        Maintain maintain = maintainMapper.selectMaintainByid(id);
        return maintain;
    }

    @Override
    public Integer update_PropertyState(Integer id) {
        Integer integer = maintainMapper.update_PropertyState(id);
        return integer;
    }
}
