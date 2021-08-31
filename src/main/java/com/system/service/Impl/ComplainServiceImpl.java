package com.system.service.Impl;

import com.system.mapper.ComplainMapper;
import com.system.pojo.Complain;
import com.system.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    private ComplainMapper complainMapper;
    public List<Complain> selectAll(){
        List<Complain> complains = complainMapper.selectAll();
        return complains;
    }
    public Integer updateState(Integer id){
        Integer integer = complainMapper.updateState(id);
        return integer;
    }
}
