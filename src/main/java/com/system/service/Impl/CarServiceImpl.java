package com.system.service.Impl;

import com.system.mapper.CarMapper;
import com.system.pojo.Car;
import com.system.pojo.User_Account;
import com.system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> selectAll() {
        List<Car> cars = carMapper.selectAll();
        return cars;
    }

    @Override
    public Car selectById(Integer id) {
        Car car = carMapper.selectById(id);
        return car;
    }

    @Override
    public Integer insert(Car car) {
        Integer insert = carMapper.insert(car);
        return insert;
    }

    @Override
    public Integer delete(Integer id) {
        Integer delete = carMapper.delete(id);
        return delete;
    }

    @Override
    public Integer update(Car car) {
        Integer update = carMapper.update(car);
        return update;
    }

    @Override
    public List<User_Account> selectUser() {
        List<User_Account> user_accounts = carMapper.selectUser();
        return user_accounts;
    }

    @Override
    public Car selectByCarId(String car_id) {
        Car car = carMapper.selectByCarId(car_id);
        return car;
    }

    @Override
    public Integer selectByIdCard(String idcard) {
        Integer integer = carMapper.selectByIdCard(idcard);
        return integer;
    }
}
