package com.system.mapper;

import com.system.pojo.Floor;
import com.system.pojo.Room;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoomMapper {
    @Select("select * from room")
    public List<Room> selectAll();

    @Select("select * from room where room_id=#{id}")
    public Room selectById(Integer id);

    @Insert("insert into room (floor_name,floor_unit,room_number,room_area)values(#{floor_name},#{floor_unit},#{room_number},#{room_area})")
    public Integer insert(Room room);

    @Delete("delete from room where room_id=#{id}")
    public Integer delete(Integer id);

    @Update("update room set floor_name=#{floor_name},floor_unit=#{floor_unit},room_number=#{room_number},room_area=#{room_area} where room_id=#{room_id}")
    public Integer update(Room room);

    @Select("select floor_name from floor")
    public List<String> selectfloor_name();

    @Select("select * from floor where floor_name=#{floor_name}")
    public Floor selectFloor(String floor_name);

    @Select("select * from room where floor_name=#{floor_name} and floor_unit=#{floor_unit} and room_number=#{room_number}")
    public Room selectRoom(Room room);

    @Select("select * from room where floor_name=#{floor_name}")
    public List<Room> selectByFloor_Name(String floor_name);
}
