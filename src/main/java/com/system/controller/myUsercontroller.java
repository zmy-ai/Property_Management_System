package com.system.controller;

import com.system.mapper.DateMapper;
import com.system.pojo.Admin_Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class myUsercontroller {
    @Autowired
    private DateMapper myUserMapper;
    @RequestMapping("/show.do")
    public  ModelAndView show(){
        List<Admin_Account> select = myUserMapper.select();

        System.out.println(select);
        System.out.println("已经进入了校区物业管理系统的后端！");
        return null;

    }
}
