package com.system.service;

import com.system.pojo.Complain;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ComplainService {
    public List<Complain> selectAll();
    public Integer updateState(Integer id);
}
