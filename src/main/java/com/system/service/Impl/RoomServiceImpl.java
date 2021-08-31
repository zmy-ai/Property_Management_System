package com.system.service.Impl;

import com.system.mapper.RoomMapper;
import com.system.pojo.Floor;
import com.system.pojo.Room;
import com.system.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> selectAll() {
        List<Room> rooms = roomMapper.selectAll();
        return rooms;
    }

    @Override
    public Room selectById(Integer id) {
        Room room = roomMapper.selectById(id);
        return room;
    }

    @Override
    public Integer insertFloor(Room room) {
        Integer insert = roomMapper.insert(room);
        return insert;
    }

    @Override
    public Integer deleteFloor(Integer id) {
        Integer delete = roomMapper.delete(id);
        return delete;
    }

    @Override
    public Integer updateFloor(Room room) {
        Integer update = roomMapper.update(room);
        return update;
    }

    @Override
    public List<String> selectFloor_name() {
        List<String> list = roomMapper.selectfloor_name();
        return list;
    }

    @Override
    public Floor selectFloor(String floor_name) {
        Floor floor = roomMapper.selectFloor(floor_name);
        return floor;
    }

    @Override
    public Room selectRoom(Room room) {
        Room room1 = roomMapper.selectRoom(room);
        return room1;
    }

    @Override
    public List<Room> selectByFloor_name(String floor_name) {
        List<Room> roomList = roomMapper.selectByFloor_Name(floor_name);
        return roomList;
    }
}
