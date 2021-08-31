package com.system.controller;

import com.system.pojo.Admin_Account;
import com.system.pojo.User_Account;
import com.system.service.Login_ReserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class Login_RegisterController {
    @Autowired
    private Login_ReserviceService login_reserviceService;

    @RequestMapping("login.do")
    public void Login(String usermane, String password, String role, HttpServletRequest request, HttpServletResponse response) throws IOException {
       //设置前端后端交互的数据格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");

        System.out.println(usermane);
        System.out.println(password);
        System.out.println(role);

         //判断输入的账号密码时候为空，若为空，则返回登录界面
        PrintWriter writer = response.getWriter();

        //判断用户的角色
        if(role.equals("Admin")){
            //查询数据数是否存在该账号
            Admin_Account admin_account = login_reserviceService.selectByName_Admin(usermane);
            //判断用户是否存在，若用户不存在，则返回登录界面
            if (admin_account==null){
                writer.print("<script>alert('您输入的账号不存在，请先注册账号！！！');window.location='Login.html';</script>");
                return;
            }
            //判断用户密码时候正确，若密码正确，则进入系统，否则返回登录界面
            if (admin_account.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("Admin_username",admin_account.getUsername());
                response.sendRedirect("/Home.jsp");
            }else {
                writer.print("<script>alert('用户密码错误，请重新输入！！！');window.location='Login.html';</script>");
                return;
            }
        }else if(role.equals("User")){
            User_Account user_account = login_reserviceService.selectUserIdcard(usermane);
            //判断用户是否存在，若用户不存在，则返回登录界面
            if (user_account==null){
                writer.print("<script>alert('您输入的账号不存在，请先注册账号！！！');window.location='Login.html';</script>");
                return;
            }

            //判断用户密码时候正确，若密码正确，则进入系统，否则返回登录界面
            if (user_account.getPassword().equals(password)){
                HttpSession session = request.getSession();
                session.setAttribute("user_account",user_account);
                response.sendRedirect("Users/Home.jsp");
            }else {
                writer.print("<script>alert('用户密码错误，请重新输入！！！');window.location='Login.html';</script>");
                return;
            }
        }
    }

    @RequestMapping("/register.do")
    public  ModelAndView  register(Admin_Account admin_account, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");

        ModelAndView modelAndView = new ModelAndView();
        //查询数据数是否存在该账号
        Admin_Account account = login_reserviceService.selectByName_Admin(admin_account.getUsername());
        if (account!=null){
            modelAndView.setViewName("Tips/already");
        }else{
            Integer integer = login_reserviceService.insertUser(admin_account);
            if (integer!=0){
                modelAndView.setViewName("Tips/Regiseter_ success");
            }
        }
        return modelAndView;

    }
}
