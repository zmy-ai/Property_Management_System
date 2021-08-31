package com.system.service.Impl;

import com.system.mapper.RoomBindingMapper;
import com.system.pojo.Room;
import com.system.pojo.User_Account;
import com.system.service.RoomBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomBindingServiceImpl implements RoomBindingService {
    @Autowired
    private RoomBindingMapper roomBindingMapper;
    @Override
    public List<User_Account> selectAll() {
        List<User_Account> user_accounts = roomBindingMapper.selectAll();
        return user_accounts;
    }

    @Override
    public List<Room> selectRoomId(Integer user_id) {
        List<Room> roomList = roomBindingMapper.selectRoomId(user_id);
        return roomList;
    }

    @Override
    public Integer setState(Integer id) {
        Integer integer = roomBindingMapper.setState(id);
        return integer;
    }

    @Override
    public List<Room> selectRoom() {
        List<Room> roomList = roomBindingMapper.selectRoom();
        return roomList;
    }

    @Override
    public Integer setRoomState(Room room) {
        Integer integer = roomBindingMapper.setRoomState(room);
        return integer;
    }


}
