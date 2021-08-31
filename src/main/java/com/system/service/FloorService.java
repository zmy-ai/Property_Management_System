package com.system.service;

import com.system.pojo.Floor;
import java.util.List;

public interface FloorService {

    /**
     * 查找所有的楼栋信息
     * @return 所有楼栋信息的list集合
     */
    public List<Floor> selectAll();

    /**
     * 根据楼栋id查找楼栋信息
     * @param id 查找的楼栋id
     * @return 返回对应ID号的楼栋信息
     */
    public Floor selectById(Integer id);

    /**
     * 根据楼栋名称返回楼栋信息
     * @param floor_name 楼栋名称
     * @return 返回一份楼的信息
     */
    public Floor selectFloor_name(String floor_name);

    /**
     * 插入楼栋信息
     * @param floor 被插入的楼栋信息的集合
     * @return 数据库中数据表被修改的行数
     */
    public Integer insertFloor(Floor floor);

    /**
     * 根据id删除信息
     * @param id 删除楼栋信息的id
     * @return 数据库中数据表被修改的行数
     */
    public Integer deleteFloor(Integer id);

    /**
     * 更新数据库中某条数据的信息
     * @param floor 更新后的信息
     * @return 数据库数据表的给修改的行数
     */
    public Integer updateFloor(Floor floor);
}
