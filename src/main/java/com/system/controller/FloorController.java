package com.system.controller;

import com.system.pojo.Floor;
import com.system.pojo.User_Account;
import com.system.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class FloorController {
    @Autowired
    private FloorService floorService;

    @RequestMapping("/Floorshow.do")
    public  ModelAndView floorShow(){
        List<Floor> floors = floorService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", floors);
        modelAndView.setViewName("Floor.jsp");
        return modelAndView;
    }

    @RequestMapping("/addFloor.do")
    public  ModelAndView addFloor(Floor floor, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8;");
        System.out.println(floor);
        Floor f = floorService.selectFloor_name(floor.getFloor_name());
        if (f!=null){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("Tips/AddFloor_failure");
            return modelAndView;
        }else{
            Integer integer = floorService.insertFloor(floor);
            if (integer!=0){
                return floorShow();
            }
        }
        return null;
    }

    @RequestMapping("/delFloor.do")
    public ModelAndView delFloor(Integer id){
        Integer integer = floorService.deleteFloor(id);
        if (integer!=0){
            return floorShow();
        }
        return null;
    }

    @RequestMapping("/updateFloor.do")
    public ModelAndView updateFloor(Integer id){
        Floor floor = floorService.selectById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("floor",floor);
        modelAndView.setViewName("editFloor.jsp");
        return modelAndView;
    }

    @RequestMapping("/editFloor.do")
    public ModelAndView editFloor(String oldfloor_name,Floor floor){
        System.out.println(oldfloor_name);
        System.out.println("修改之后："+floor);
        //判断是否存在该楼
        if (oldfloor_name.equals(floor.getFloor_name())){
            Integer integer = floorService.updateFloor(floor);
            if (integer!=0){
                return floorShow();
            }
        }else{
            Floor floor1 = floorService.selectFloor_name(floor.getFloor_name());
            if (floor1==null){
                Integer integer = floorService.updateFloor(floor);
                if (integer!=0){
                    return floorShow();
                }
            }else{
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.addObject("floor",floor);
                modelAndView.setViewName("editFloor.jsp");
                return modelAndView;
            }
        }
        return null;
    }

    @RequestMapping("/deleteFloors.do")
    public ModelAndView deleteFloors(Integer []chick){
        System.out.println(chick);
        if(chick==null){
            return floorShow();
        }
        for (Integer id:chick){
            floorService.deleteFloor(id);
        }
        return floorShow();
    }

    @RequestMapping("/queryFloors.do")
    public ModelAndView queryFloors(Integer [] chick){
        if(chick==null){
            return floorShow();
        }
        System.out.println("查询的id："+ Arrays.toString(chick));
        List<Floor> list=new ArrayList<>();
        for (Integer id:chick){
            Floor floor = floorService.selectById(id);
            list.add(floor);
        }
        System.out.println("被查询的数据：");
        System.out.println(list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("Floor.jsp");
        return modelAndView;
    }

    @RequestMapping("/selectByFName.do")
    public ModelAndView selectfloor_Name(String floor_name){
        if (floor_name==null||floor_name.equals("")){
            return floorShow();
        }
        List<Floor> list=new ArrayList<>();
        Floor floor = floorService.selectFloor_name(floor_name);
        list.add(floor);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("Floor.jsp");
        return modelAndView;
    }

}
