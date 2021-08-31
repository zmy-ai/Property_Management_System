package com.system.service;

import com.system.pojo.Payment;
import com.system.pojo.User_Account;

import java.util.List;

public interface PaymentService {
    public List<Payment> selectAll();
    public List<User_Account> selectAllUser_Account();
    public Integer selectByIdCard(String idcard);
    public Integer insert(Payment payment);
    public Payment selectByid(Integer id);
    public User_Account selectUserById(Integer user_id);
    public Integer updatePayment(Payment payment);
    public  Integer deletePayment(Integer id);

}
