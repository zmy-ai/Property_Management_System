package com.system.service;

import com.system.pojo.Maintain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface MaintainService {

    public List<Maintain> selectAll();

    public Integer insertUser_maintain(Maintain maintain);

    public Maintain selectMaintainByid(Integer id);

    public Integer update_PropertyState(Integer id);
}
