package com.system.service.Impl;

import com.system.mapper.DateMapper;
import com.system.pojo.Admin_Account;
import com.system.pojo.User_Account;
import com.system.service.Login_ReserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Login_ReserviceServiceImpl implements Login_ReserviceService {
    @Autowired
    private DateMapper dateMapper;
    @Override
    public Admin_Account selectByName_Admin(String username) {
        Admin_Account admin_account = dateMapper.selectByName_Admin(username);
        return  admin_account;
    }

    @Override
    public Integer insertUser(Admin_Account admin_account) {
        Integer integer = dateMapper.insertinto_Admin(admin_account);
        return integer;
    }

    public User_Account selectUserIdcard(String userIdcard){
        User_Account user_account = dateMapper.selectUserIdcard(userIdcard);
        return user_account;
    }
}
