package com.system.mapper;

import com.system.pojo.Car;
import com.system.pojo.User_Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface CarMapper {

    /**
     * 根据id找用户
     * @return
     */
    @Select("select * from car")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(id = true,column = "car_id",property = "car_id"),
            @Result(column = "type",property = "type"),
            @Result(column = "car_area",property = "car_area"),
            @Result(column = "createtime",property = "createtime"),
            @Result(column = "outTime",property = "outTime"),
            @Result(column = "user_id",property = "user_account",one=@One(select = "com.system.mapper.User_AccountMapper.selectById",fetchType = FetchType.EAGER))
    })
    public List<Car> selectAll();

    @Select("select * from car where id=#{id}")
    public Car selectById(Integer id);

    @Select("select * from car where car_id=#{car_id}")
    public Car selectByCarId(String car_id);

    @Select("select id from user_account where idcard=#{idcard}")
    public Integer selectByIdCard(String idcard);

    @Insert("insert into car(car_id,type,car_area,createtime,outTime,user_id)values(#{car_id},#{type},#{car_area},#{createtime},#{outTime},#{user_id})")
    public Integer insert(Car car);

    @Delete("delete from car where id=#{id}")
    public Integer delete(Integer id);

    @Update("update car set car_id=#{car_id},type=#{type},car_area=#{car_area},createtime=#{createtime},outTime=#{outTime},user_id=#{user_id} where id=#{id}")
    public Integer update(Car car);

    @Select("select * from user_account")
    public List<User_Account> selectUser();
}
