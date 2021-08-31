package com.system.service.Impl;

import com.system.mapper.floorMapper;
import com.system.pojo.Floor;
import com.system.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private floorMapper floorMapper;
    @Override
    public List<Floor> selectAll() {
        List<Floor> floors = floorMapper.selectAll();
        return floors;
    }

    @Override
    public Floor selectById(Integer id) {
        Floor floor = floorMapper.selectByid(id);
        return floor;
    }

    @Override
    public Floor selectFloor_name(String floor_name) {
        Floor floor = floorMapper.selectByFloor_name(floor_name);
        return floor;
    }

    @Override
    public Integer insertFloor(Floor floor) {
        Integer integer = floorMapper.insertFloor(floor);
        return integer;
    }

    @Override
    public Integer deleteFloor(Integer id) {
        Integer integer = floorMapper.deleteFloor(id);
        return integer;
    }

    @Override
    public Integer updateFloor(Floor floor) {
        Integer integer = floorMapper.updateFloor(floor);
        return integer;
    }
}
