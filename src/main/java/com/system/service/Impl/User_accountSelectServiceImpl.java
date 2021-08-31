package com.system.service.Impl;

import com.system.mapper.User_accountselectMapper;
import com.system.pojo.*;
import com.system.service.User_accountSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Service
public class User_accountSelectServiceImpl implements User_accountSelectService {
    @Autowired
    private User_accountselectMapper user_accountselectMapper;
    public List<Room> selectUser_floor(Integer user_id){
        List<Room> roomList = user_accountselectMapper.selectUser_floor(user_id);
        return roomList;
    }

    public List<Car> selectUser_car(Integer user_id){
        List<Car> cars = user_accountselectMapper.selectUser_car(user_id);
        return cars;
    }

    public Car selectUser_carId(Integer id){
        Car car = user_accountselectMapper.selectUser_carId(id);
        return car;
    }

    public User_Account selectUserByid(Integer id){
        User_Account user_account = user_accountselectMapper.selectUserByid(id);
        return user_account;
    }

    public List<Payment> selectUser_payment(Integer user_id){
        List<Payment> payments = user_accountselectMapper.selectUser_payment(user_id);
        return payments;
    }

    public List<Maintain> selectUser_maintain(Integer user_id){
        List<Maintain> maintains = user_accountselectMapper.selectUser_maintain(user_id);
        return maintains;
    }
    public Integer insertUser_maintain(Maintain maintain){
        Integer integer = user_accountselectMapper.insertUser_maintain(maintain);
        return integer;
    }

    public Maintain selectMaintainByid(Integer id){
        Maintain maintain = user_accountselectMapper.selectMaintainByid(id);
        return maintain;
    }

    public Integer update_UserState(Integer id){
        Integer integer = user_accountselectMapper.update_UserState(id);
        return integer;
    }

    public Integer deletemaintain(Integer id){
        Integer deletemaintain = user_accountselectMapper.deletemaintain(id);
        return deletemaintain;
    }

    public  List<Complain> selectUser_Complain(Integer id){
        List<Complain> complains = user_accountselectMapper.selectUser_Complain(id);
        return complains;
    }
    public  Integer deleteUser_Complain(Integer id){
        Integer integer = user_accountselectMapper.deleteUser_Complain(id);
        return integer;
    }

    public Integer insertComplain(Complain complain){
        Integer integer = user_accountselectMapper.insertComplain(complain);
        return integer;
    }
}
