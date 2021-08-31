package com.system.mapper;

import com.system.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface User_accountselectMapper {
    @Select("select * from room where user_id=#{user_id}")
    public List<Room> selectUser_floor(Integer user_id);

    @Select("select * from car where user_id=#{user_id}")
    public List<Car> selectUser_car(Integer user_id);

    @Select("select * from car where id=#{id}")
    public Car selectUser_carId(Integer id);

    @Select("select * from user_account where id=#{id}")
    public User_Account selectUserByid(Integer id);

    @Select("select * from payment where user_id=#{user_id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "pay_name",property = "pay_name"),
            @Result(column = "money",property = "money"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "user_id",property = "user_id"),
            @Result(column = "explain",property = "explain"),
            @Result(column = "pay_state",property = "pay_state"),
            @Result(column = "createTime",property = "createTime"),
            @Result(column = "user_id",property = "user_account",
                    one = @One(select = "com.system.mapper.User_accountselectMapper.selectUserByid",fetchType = FetchType.EAGER))
    })
    public List<Payment> selectUser_payment(Integer user_id);


    @Select("select * from maintain where user_id=#{user_id};")
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
    public List<Maintain> selectUser_maintain(Integer user_id);

    @Insert("insert into maintain(title,detail,`name`,user_id,address,phone,property_state,user_state)values(#{title},#{detail},#{name},#{user_id},#{address},#{phone},#{property_state},#{user_state})")
    public Integer insertUser_maintain(Maintain maintain);

    @Select("select * from maintain where id=#{id}")
    public Maintain selectMaintainByid(Integer id);

    @Update("update maintain set user_state='已确认' where id=#{id}")
    public Integer update_UserState(Integer id);

    @Delete("delete from maintain where id=#{id}")
    public Integer deletemaintain(Integer id);

    @Select("select * from complaint where user_id=#{id}")
    public  List<Complain> selectUser_Complain(Integer id);

    @Select("delete from complaint where id=#{id}")
    public  Integer deleteUser_Complain(Integer id);

    @Insert("insert into complaint(title,detail,`name`,user_id,property_state) values(#{title},#{detail},#{name},#{user_id},#{property_state})")
    public Integer insertComplain(Complain complain);
}
