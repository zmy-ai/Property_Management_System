package com.system.service;

import com.system.pojo.Floor;
import com.system.pojo.Room;

import java.util.List;

public interface RoomService {

    /**
     * 查询所有的套房信息
     * @return 返回所有套房信息的list集合
     */
    public List<Room> selectAll();

    /**
     * 根据id
     * @param id
     * @return
     */
    public Room selectById(Integer id);

    /**
     * 插入套房信息
     * @param room 被插入套房的信息
     * @return 数据库中数据表被修改的行数
     */
    public Integer insertFloor(Room room);

    /**
     * 删除套房信息
     * @param id 给删除套房的ID号
     * @return 数据库中数据表的被修改的行数
     */
    public Integer deleteFloor(Integer id);

    /**
     * 更新房间信息
     * @param room 更新后的房间信息数据
     * @return 数据库中数据库中数据表非修改的行数
     */
    public Integer updateFloor(Room room);

    public List<String> selectFloor_name();

    /**
     * 根据
     * @param floor_name
     * @return
     */
    public Floor selectFloor(String floor_name);

    /**
     *
     * @param room
     * @return
     */
    public Room selectRoom(Room room);

    /**
     * 根据楼栋查找房间
     * @param floor_name 楼栋名称
     * @return 返回属于查找楼栋的所有房间名称
     */
    public List<Room> selectByFloor_name(String floor_name);

}
