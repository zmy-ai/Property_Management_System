package com.system.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.system.mapper.RoomMapper;
import com.system.pojo.Floor;
import com.system.pojo.Room;
import com.system.service.RoomService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping("/roomshow.do")
    public ModelAndView roomshow(){
        List<Room> rooms = roomService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", rooms);
        modelAndView.setViewName("Room.jsp");
        return modelAndView;
    }

    @RequestMapping("/add.do")
    public ModelAndView addRoom(){
        List<String> list = roomService.selectFloor_name();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("AddRoom.jsp");
        return modelAndView;
    }

    @RequestMapping("/addRoom.do")
    public ModelAndView addRoom(Room room, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8;");
        response.setCharacterEncoding("utf8");
        Floor floor = roomService.selectFloor(room.getFloor_name());
        ModelAndView modelAndView = new ModelAndView();
        //判断单元号是否存在
        if (floor.getUnit()<Integer.parseInt(room.getFloor_unit())){
            //不存在，返回错误提示
            modelAndView.setViewName("Tips/Not_Found_Unit");
            return modelAndView;
        }else{
            //存在，判断房间号是偶已经添加过了
            room.setFloor_unit(room.getFloor_unit()+"单元");
            System.out.println(room);
            Room room1 = roomService.selectRoom(room);
            if (room1!=null){
                modelAndView.setViewName("Tips/AddRoom_already");
                return modelAndView;
            }else{
                Integer integer = roomService.insertFloor(room);
                if (integer!=0){
                    return roomshow();
                }
            }
        }
      return null;
    }

    @RequestMapping("/upRoom.do")
    public ModelAndView upRoom(Integer id){
        Room room = roomService.selectById(id);
        String unit=room.getFloor_unit().substring(0,room.getFloor_unit().indexOf("单元"));
        room.setFloor_unit(unit);
        List<String> list = roomService.selectFloor_name();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",list);
        modelAndView.addObject("room",room);
        modelAndView.setViewName("editRoom.jsp");
        return modelAndView;
    }

    @RequestMapping("/editRoom.do")
    public ModelAndView editRoom(Room room,HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf8");
        response.setContentType("text/html;charset=utf-8;");
        Room room1 = roomService.selectById(room.getRoom_id());
        room.setFloor_unit(room.getFloor_unit()+"单元");
        //判断房间号时候为原来的房间号，若是，则直接修改，若不是，则判断是否已经添加过的房间号
        if(room.getFloor_name().equals(room1.getFloor_name())&&room.getFloor_unit().equals(room1.getFloor_unit())&&room.getRoom_number().equals(room1.getRoom_number())){
            Integer integer = roomService.updateFloor(room);
            return roomshow();
        }else{
            //判断是否为已经添加过的房间号
            Room r = roomService.selectRoom(room);
            if (r!=null){
               response.getWriter().print("<script>alert('抱歉，您输入的房间号已经存在！！');</script>");
                return upRoom(room.getRoom_id());
            }else{
                Integer integer = roomService.updateFloor(room);
                return roomshow();
            }
        }
    }

    @RequestMapping("/delRoom.do")
    public ModelAndView delRoom(Integer id){
        Integer integer = roomService.deleteFloor(id);
        if (integer!=0){
            return roomshow();
        }
        return null;
    }

    @RequestMapping("/queryRooms.do")
    public ModelAndView queryRooms(Integer [] chick){
        if (chick==null){
            return roomshow();
        }
        System.out.println(Arrays.toString(chick));
        List<Room> roomList=new ArrayList<Room>();
        for(Integer id:chick){
            Room room = roomService.selectById(id);
            roomList.add(room);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",roomList);
        modelAndView.setViewName("Room.jsp");
        return modelAndView;
    }

    @RequestMapping("/delRooms.do")
    public ModelAndView delRooms(Integer [] chick){
        if (chick!=null){
            for (Integer id:chick){
                Integer integer = roomService.deleteFloor(id);
            }
        }
        return roomshow();
    }

    @RequestMapping("/selectByFloorName.do")
    public ModelAndView selectRooms(String floor_name){
        if (floor_name==null||floor_name.equals("")){
            return roomshow();
        }
        List<Room> roomList = roomService.selectByFloor_name(floor_name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",roomList);
        modelAndView.setViewName("Room.jsp");
        return modelAndView;
    }
}
