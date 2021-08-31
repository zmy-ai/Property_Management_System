package com.system.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.Util.FileUtil;
import com.system.pojo.User_Account;
import com.system.service.User_AccountService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.Logger;

@Controller
public class User_AccountController {
    private static Logger logger= Logger.getLogger(User_AccountController.class);

    @Autowired
    private User_AccountService user_accountService;

    @RequestMapping("/user.do")
    public ModelAndView  user(){
        List<User_Account> list = user_accountService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("proprietor.jsp");
        return modelAndView;

    }
    @RequestMapping("/addUser.do")
    public ModelAndView addUser(User_Account user_account, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");

        //判断用户是否已经添加，已经添加，返回添加页面
        ModelAndView modelAndView = new ModelAndView();
        User_Account account = user_accountService.selectByIdCard(user_account.getIdcard());
        if(account!=null){
            modelAndView.setViewName("Tips/AddUser_failure");
            return modelAndView;
        }

        //判断是否有手动设置密码，若没有设置，默认密码为证件号的后6位
        if (user_account.getPassword().equals("")||user_account.getPassword()==null){
            String password=user_account.getIdcard();
            user_account.setPassword(password.substring(password.length()-6));
        }

        //设置创建时间
        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println("java.sql 时间："+date1);
        user_account.setCreateTime(date1);


        System.out.println(user_account);

        if (account==null){
            //添加业主信息
            Integer integer = user_accountService.insertUser(user_account);
            if (integer!=0){
                return user();
            }else {
                modelAndView.setViewName("Tips/AddUser_failure");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/delUser.do")
    public ModelAndView delUser(Integer id){
        Integer integer = user_accountService.deleteUser(id);
        return user();
    }

    @RequestMapping("/upUser.do")
    public  ModelAndView upUser(Integer id){
        System.out.println("进入了编辑");
        User_Account user_account = user_accountService.selectById(id);
        System.out.println(user_account);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user_account);
        modelAndView.setViewName("edit.jsp");
        return modelAndView;
    }

    @RequestMapping("/edit.do")
    public ModelAndView saveUser(String Oid,User_Account account,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");

        //设置修改时间
        Date date = new Date();
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println("java.sql 时间："+date1);
        account.setCreateTime(date1);

        System.out.println(Oid);
        System.out.println("编辑后的信息：");
        System.out.println(account);
        ModelAndView modelAndView = new ModelAndView();
        //判断证件如果未修改，则直接保存至数据库，如果修改了，则判断数据库是否已经存在
        if(Oid.equals(account.getIdcard())== true){
            Integer integer = user_accountService.uptadeUser(account);
            //判断是否修改成功
            if (integer!=0){
                return user();
            }
        }else{
            User_Account account_user = user_accountService.selectByIdCard(account.getIdcard());
            //证件号数据库已经存在
            if(account_user!=null){
                modelAndView.setViewName("Tips/upUser_failure");
                return modelAndView;
            }
            Integer integer = user_accountService.uptadeUser(account);
            //判断是否修改成功
            if (integer!=0){
                return user();
            }
        }
        return null;
    }

    @RequestMapping("/queryUsers.do")
    public ModelAndView queryUsers(Integer []chick ){

        System.out.println("进来了进来了！");
        System.out.println(chick);
        if (chick==null){
            return user();
        }
        List<User_Account> userList=new ArrayList<User_Account>();
        for (Integer id:chick){
            User_Account user_account = user_accountService.selectById(id);
            userList.add(user_account);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",userList);
        modelAndView.setViewName("proprietor.jsp");
        return  modelAndView;
    }
    @RequestMapping("/delUsers.do")
    public ModelAndView delUsers(Integer []chick){
        if (chick==null)
            return user();
        for (Integer id:chick){
            Integer integer = user_accountService.deleteUser(id);
        }
        return user();
    }

    @RequestMapping("/updateUsers.do")
    public  ModelAndView  updateUsers(Integer [] chick){
        System.out.println("批量更新，进来了");
        if (chick==null)
            return user();
        ArrayList<User_Account> list = new ArrayList<>();
        for (Integer id:chick){
            User_Account user_account = user_accountService.selectById(id);
            list.add(user_account);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("edit_Users.jsp");
        return modelAndView;
    }


    /**
     * 导出excel
     * @param response
     * @param request
     */
    @RequestMapping("/queryExportUser.do")
    public ModelAndView queryExportUser(HttpServletResponse response,HttpServletRequest request){
        OutputStream ouputStream = null;
        try {
            Workbook wb = user_accountService.queryExportUser();
            FileUtil.setResponse(request,response,"用户表_"+ UUID.randomUUID()+".xlsx");
            ouputStream = response.getOutputStream();
            wb.write(ouputStream);
            ouputStream.flush();
        } catch (Exception e) {
            logger.error("[queryExportUser]异常", e);
        } finally {
            if (ouputStream != null) {
                try {
                    ouputStream.close();
                } catch (IOException e) {
                    logger.error("[queryExportUser]输出流关闭异常", e);
                }
            }
        }
        return user();
    }
}
