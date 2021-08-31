package com.system.service.Impl;

import com.system.mapper.PaymentMapper;
import com.system.pojo.Payment;
import com.system.pojo.User_Account;
import com.system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;
    public List<Payment> selectAll(){
        List<Payment> payments = paymentMapper.selectAll();
        return payments;
    }
    public List<User_Account> selectAllUser_Account(){
        List<User_Account> user_accounts = paymentMapper.selectAllUser_Account();
        return user_accounts;
    }

    public Integer selectByIdCard(String idcard){
        Integer integer = paymentMapper.selectByIdCard(idcard);
        return integer;
    }
    public Integer insert(Payment payment){
        Integer insert = paymentMapper.insert(payment);
        return insert;
    }
    public Payment selectByid(Integer id){
        Payment payment = paymentMapper.selectByid(id);
        return payment;
    }
    public User_Account selectUserById(Integer user_id){
        User_Account user_account = paymentMapper.selectUserById(user_id);
        return user_account;
    }
    public Integer updatePayment(Payment payment){
        Integer integer = paymentMapper.updatePayment(payment);
        return integer;
    }
    public  Integer deletePayment(Integer id){
        Integer integer = paymentMapper.deletePayment(id);
        return integer;
    }

}
