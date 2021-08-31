package com.system.mapper;

import com.system.pojo.Maintain;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface MaintainMapper {
    @Select("select * from maintain")
    @Results({
            @Result(id = true,column ="id",property = "id"),
            @Result(column ="title",property = "title"),
            @Result(column ="detail",property = "detail"),
            @Result(column ="name",property = "name"),
            @Result(column ="user_id",property = "user_id"),
            @Result(column = "address",property = "address"),
            @Result(column = "phone",property = "phone"),
            @Result(column ="property_state",property = "property_state"),
            @Result(column ="user_state",property = "user_state"),
            @Result(column ="user_id",property = "user_account",
                    one = @One(select = "com.system.mapper.User_accountselectMapper.selectUserByid",fetchType = FetchType.EAGER))
    })
    public List<Maintain> selectAll();

    @Insert("insert into maintain(title,detail,`name`,user_id,address,phone,property_state,user_state)values(#{title},#{detail},#{name},#{user_id},#{address},#{phone},#{property_state},#{user_state})")
    public Integer insertUser_maintain(Maintain maintain);

    @Select("select * from maintain where id=#{id}")
    public Maintain selectMaintainByid(Integer id);

    @Update("update maintain set property_state='已完成' where id=#{id}")
    public Integer update_PropertyState(Integer id);
}
