package com.system.controller;

import com.system.pojo.*;
import com.system.service.RoomBindingService;
import com.system.service.User_accountSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.applet.Main;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class User_PropritorController {
    @Autowired
    private User_accountSelectService userAccountSelectService;
    @Autowired
    private RoomBindingService roomBindingService;

    /**
     * 用户房产展示
     * @param id 用户id
     * @return 用户房产展示页面
     */
    @RequestMapping("/User_Floorshow.do")
    public ModelAndView User_Floorshow(Integer id){
        List<Room> roomList = userAccountSelectService.selectUser_floor(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", roomList);
        modelAndView.setViewName("Users/RoomDetails.jsp");
        return  modelAndView;
    }

    /**
     * 用户房号解除
     * @param id
     * @param user_id
     * @return
     */
    @RequestMapping("/removeRoom.do")
    public ModelAndView relieveRoom(Integer id,Integer user_id){
        Integer integer = roomBindingService.setState(id);
        return User_Floorshow(user_id);
    }

    /**
     * 用户车位展示
     * @param id 用户id
     * @return
     */
    @RequestMapping("/User_Carshow.do")
    public ModelAndView User_Carshow(Integer id){
        List<Car> cars = userAccountSelectService.selectUser_car(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",cars);
        modelAndView.setViewName("Users/Car.jsp");
        return modelAndView;
    }

    @RequestMapping("/DetailCar.do")
    public ModelAndView DetailCar(Integer id){
        Car car = userAccountSelectService.selectUser_carId(id);
        User_Account user_account = userAccountSelectService.selectUserByid(car.getUser_id());
        String name_card=user_account.getUsername()+"_"+user_account.getIdcard();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("car", car);
        modelAndView.addObject("name_card",name_card);
        modelAndView.setViewName("Users/DetailsCar.jsp");
        return modelAndView;
    }

    /**
     * 展示缴费信息
     * @param id 用户id
     * @return
     */
    @RequestMapping("/User_showPay.do")
    public ModelAndView User_showPay(Integer id){
        List<Payment> payments = userAccountSelectService.selectUser_payment(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",payments);
        modelAndView.setViewName("Users/Payment.jsp");
        return modelAndView;
    }

    /**
     * 展示报修信息
     * @param id
     * @return
     */
    @RequestMapping("/User_maintain.do")
    public ModelAndView User_maintain(Integer id){
        List<Maintain> maintains = userAccountSelectService.selectUser_maintain(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", maintains);
        modelAndView.setViewName("Users/Maintain.jsp");
        return  modelAndView;
    }

    /**
     * 添加报修信息
     * @param maintain 报修信息
     * @param userId 报修用户id
     * @return
     */
    @RequestMapping("/addMaintain.do")
    public ModelAndView addMaintain(Maintain maintain,Integer userId){
        maintain.setUser_id(userId);
        System.out.println(maintain);
        System.out.println(userId);

        Integer integer = userAccountSelectService.insertUser_maintain(maintain);
        return User_maintain(userId);
    }

    /**
     * 用户确认维修
     * @param id 维修信息编号
     * @param userId 维修用户id
     * @return
     */
    @RequestMapping("/upMaintain.do")
    public ModelAndView upMaintain(Integer id,Integer userId){
        Maintain maintain = userAccountSelectService.selectMaintainByid(id);
        System.out.println(maintain);
        Integer integer = userAccountSelectService.update_UserState(id);
        return User_maintain(userId);
    }

    @RequestMapping("/delMaintain.do")
    public ModelAndView delMaintain(Integer id,Integer userId){
        Integer deletemaintain = userAccountSelectService.deletemaintain(id);
        return User_maintain(userId);
    }

    @RequestMapping("/deleteMaintains.do")
    public ModelAndView deleteMaintains( Integer userId,Integer []chick){
        System.out.println(userId);
        System.out.println(Arrays.toString(chick));
        for (Integer id:chick){
            userAccountSelectService.deletemaintain(id);
        }
        return  User_maintain(userId);
    }

    //展示投诉界面
    @RequestMapping("/User_Complain.do")
    public ModelAndView User_Complain(Integer id){
        List<Complain> complains = userAccountSelectService.selectUser_Complain(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", complains);
        modelAndView.setViewName("Users/Complain.jsp");
        return modelAndView;
    }

    @RequestMapping("/delCompain.do")
    public ModelAndView delCompain(Integer id,Integer userId){
        Integer integer = userAccountSelectService.deleteUser_Complain(id);
        return User_Complain(userId);
    }

    @RequestMapping("/deleteComplains.do")
    public ModelAndView deleteComplains( Integer userId,Integer []chick){
        System.out.println(userId);
        System.out.println(Arrays.toString(chick));
        for (Integer id:chick){
            userAccountSelectService.deleteUser_Complain(id);
        }
        return  User_Complain(userId);
    }

    @RequestMapping("/addComplain.do")
    public  ModelAndView addComplain(Complain complain,Integer userId){

        complain.setUser_id(userId);
        System.out.println(complain);
        userAccountSelectService.insertComplain(complain);
        ModelAndView modelAndView = new ModelAndView();
        return User_Complain(userId);
    }

}
