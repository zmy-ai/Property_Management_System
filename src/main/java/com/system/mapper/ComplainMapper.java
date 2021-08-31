package com.system.mapper;

import com.system.pojo.Complain;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ComplainMapper {

    @Select("select * from complaint")
    public List<Complain> selectAll();

    @Update("update complaint set property_state='已处理' where id=#{id}")
    public Integer updateState(Integer id);
}
