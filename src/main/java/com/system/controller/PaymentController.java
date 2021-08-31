package com.system.controller;

import com.system.pojo.Payment;
import com.system.pojo.User_Account;
import com.system.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/showPay.do")
    public ModelAndView showPay(){
        List<Payment> payments = paymentService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",payments);
        modelAndView.setViewName("Payment.jsp");
        return modelAndView;
    }
    @RequestMapping("/addPayment.do")
    public ModelAndView addPay(){
        List<User_Account> user_accounts = paymentService.selectAllUser_Account();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",user_accounts);
        modelAndView.setViewName("AddPayment.jsp");
        return modelAndView;
    }

    @RequestMapping("/savePayment.do")
    public ModelAndView savePayment(Payment payment,String Time,String username) throws ParseException {
        payment.setCreateTime(new java.sql.Date(new Date().getTime()));
        if(!Time.equals("")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(Time);
            java.sql.Date outdate=new java.sql.Date(parse.getTime());
            payment.setOutTime(outdate);
        }
        if (!username.equals("无")){
            int i = username.indexOf("_");
            payment.setUser_id(paymentService.selectByIdCard(username.substring(i+1)));
        }
        System.out.println("对象："+payment);
        Integer insert = paymentService.insert(payment);
        System.out.println(insert);
        return showPay();
    }

    @RequestMapping("/upPayment.do")
    public ModelAndView upPayment(Integer id){
        Payment payment = paymentService.selectByid(id);
        ModelAndView modelAndView = new ModelAndView();
        if(payment.getUser_id()!=0){
            User_Account user_account = paymentService.selectUserById(payment.getUser_id());
            String name_card=user_account.getUsername()+"_"+user_account.getIdcard();

            System.out.println("名字和证件号："+name_card);
            modelAndView.addObject("name_card",name_card);
        }
        System.out.println("用户："+payment);
        List<User_Account> user_accounts = paymentService.selectAllUser_Account();
        modelAndView.addObject("payment",payment);
        modelAndView.addObject("list",user_accounts);
        modelAndView.setViewName("editPayment.jsp");
        return modelAndView;
    }

    @RequestMapping("/editPayment.do")
    public  ModelAndView editPayment(Payment payment,String time,String Time,String username) throws ParseException {
        System.out.println(payment);


        payment.setCreateTime(new java.sql.Date(new Date().getTime()));
        if(!Time.equals("")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(Time);
            java.sql.Date outdate=new java.sql.Date(parse.getTime());
            payment.setOutTime(outdate);
        }else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(time);
            java.sql.Date outdate=new java.sql.Date(parse.getTime());
            payment.setOutTime(outdate);
        }
        if (!username.equals("无")){
            int i = username.indexOf("_");
            payment.setUser_id(paymentService.selectByIdCard(username.substring(i+1)));
        }
        System.out.println(payment);
        Integer integer = paymentService.updatePayment(payment);
        return showPay();
    }

    @RequestMapping("/delPayment.do")
    public ModelAndView delPayment(Integer id){
        Integer integer = paymentService.deletePayment(id);
        return showPay();
    }

    @RequestMapping("/delPayments.do")
    public ModelAndView delPayments(Integer [] chick){
        if (chick==null)
            return showPay();
        for(Integer id:chick){
            Integer integer = paymentService.deletePayment(id);
        }
        return showPay();
    }

    @RequestMapping("/queryPayments.do")
    public ModelAndView queryPayments(Integer [] chick){
        if (chick==null)
            return showPay();
       List<Payment> payments= new ArrayList<Payment>();
       for (Integer id:chick){
           Payment payment = paymentService.selectByid(id);
           payments.add(payment);
       }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",payments);
        modelAndView.setViewName("Payment.jsp");
        return modelAndView;
    }
}
