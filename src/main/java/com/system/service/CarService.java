package com.system.service;

import com.system.pojo.Car;
import com.system.pojo.User_Account;

import java.util.List;

public interface CarService {
    public List<Car> selectAll();

    public Car selectById(Integer id);

    public Integer insert(Car car);

    public Integer delete(Integer id);

    public Integer update(Car car);

    public List<User_Account> selectUser();

    public Car selectByCarId(String car_id);

    public Integer selectByIdCard(String idcard);
}
