package com.system.service;

import com.system.pojo.*;

import java.util.List;

public interface User_accountSelectService {
    public List<Room> selectUser_floor(Integer user_id);

    public List<Car> selectUser_car(Integer user_id);

    public Car selectUser_carId(Integer id);

    public User_Account selectUserByid(Integer id);

    public List<Payment> selectUser_payment(Integer user_id);

    public List<Maintain> selectUser_maintain(Integer user_id);

    public Integer insertUser_maintain(Maintain maintain);

    public Maintain selectMaintainByid(Integer id);

    public Integer update_UserState(Integer id);

    public Integer deletemaintain(Integer id);

    public  List<Complain> selectUser_Complain(Integer id);

    public  Integer deleteUser_Complain(Integer id);

    public Integer insertComplain(Complain complain);
}

