package com.system.mapper;


import com.system.pojo.Floor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface floorMapper {
    @Select("select * from floor ")
    public List<Floor> selectAll();

    @Select("select * from floor where floor_name=#{floor_name}")
    public Floor selectByFloor_name(String floor_name);

    @Select("select * from floor where id=#{id}")
    public Floor selectByid(Integer id);

    @Insert("insert into floor(floor_name,unit,level,room_amount)values(#{floor_name},#{unit},#{level},#{room_amount})")
    public Integer insertFloor(Floor floor);

    @Delete("delete from floor where id=#{id}")
    public Integer deleteFloor(Integer id);

    @Update("update floor set floor_name=#{floor_name},unit=#{unit}, level=#{level},room_amount=#{room_amount} where id=#{id}")
    public Integer updateFloor(Floor floor);
}
