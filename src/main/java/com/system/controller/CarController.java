package com.system.controller;

import com.system.pojo.Car;
import com.system.pojo.User_Account;
import com.system.service.CarService;
import com.system.service.User_AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private User_AccountService user_accountService;

    @RequestMapping("/Carshow.do")
    public ModelAndView show(){
        List<Car> cars = carService.selectAll();
        System.out.println(cars);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",cars);
        modelAndView.setViewName("Car.jsp");
        return  modelAndView;
    }

    @RequestMapping("/addcar.do")
    public ModelAndView addCar(){
        List<User_Account> user_accounts = carService.selectUser();
        System.out.println(user_accounts);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",user_accounts);
        modelAndView.setViewName("AddCar.jsp");
        return modelAndView;
    }

    @RequestMapping("/saveCar.do")
    public ModelAndView saveCar(String car_id, String type, String home, String outTime, HttpServletResponse response) throws ParseException {
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf-8;");

        System.out.println(car_id);
        System.out.println(type);
        Car car = carService.selectByCarId(car_id);
        ModelAndView modelAndView = new ModelAndView();
        if (car!=null){
            modelAndView.setViewName("Tips/AddCar_already");
            return  modelAndView;
        }
        Car car1 = new Car(car_id,type);
        if (type.equals("标准型车位")){
            car1.setCar_area(16);
        }else if(type.equals("大型车位")){
            car1.setCar_area(28);
        }else if(type.equals("小型车位")){
            car1.setCar_area(13);
        }else if (type.equals("超大型车位")){
            car1.setCar_area(40);
        }
        car1.setCreatetime(new java.sql.Date(new Date().getTime()));
        if(!outTime.equals("")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(outTime);
            java.sql.Date outdate=new java.sql.Date(parse.getTime());
            car1.setOutTime(outdate);
        }
        if (!home.equals("无")){
            int i = home.indexOf("_");
            car1.setUser_id(carService.selectByIdCard(home.substring(i+1)));
        }
        System.out.println();
        Integer insert = carService.insert(car1);
        System.out.println(insert);
        return show();
    }

    @RequestMapping("/upCar.do")
    public ModelAndView upCar(Integer id){
        Car car = carService.selectById(id);
        List<User_Account> user_accounts = carService.selectUser();
        ModelAndView modelAndView = new ModelAndView();
        if(car.getUser_id()!=0){
            User_Account user_account = user_accountService.selectById(car.getUser_id());
           String name_card=user_account.getUsername()+"_"+user_account.getIdcard();
            System.out.println("名字和证件号："+name_card);
            modelAndView.addObject("name_card",name_card);
        }
        modelAndView.addObject("list",user_accounts);
        modelAndView.addObject("car",car);
        modelAndView.setViewName("EditCar.jsp");
        return modelAndView;

    }

    @RequestMapping("/editCar.do")
    public ModelAndView editCar(Integer id,String car_id, String type, String home, String outTime) throws ParseException {
        Car car1 = new Car(car_id,type);
        car1.setId(id);
        if (type.equals("标准型车位")){
            car1.setCar_area(16);
        }else if(type.equals("大型车位")){
            car1.setCar_area(28);
        }else if(type.equals("小型车位")){
            car1.setCar_area(13);
        }else if (type.equals("超大型车位")){
            car1.setCar_area(40);
        }
        car1.setCreatetime(new java.sql.Date(new Date().getTime()));
        if(!outTime.equals("")){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(outTime);
            java.sql.Date outdate=new java.sql.Date(parse.getTime());
            car1.setOutTime(outdate);
        }
        if (!home.equals("无")){
            int i = home.indexOf("_");
            car1.setUser_id(carService.selectByIdCard(home.substring(i+1)));
        }
        System.out.println(car1);
        Integer insert = carService.update(car1);
        System.out.println(insert);
        return show();
    }

    @RequestMapping("/delCar.do")
    public ModelAndView delCar(Integer id){
        Integer delete = carService.delete(id);
        if (delete!=0)
            return show();
        return null;
    }

    @RequestMapping("/delCars.do")
    public ModelAndView delCar(Integer []chick){
        if (chick!=null)
        for (Integer id:chick){
            carService.delete(id);
        }
        return show();
    }
}
