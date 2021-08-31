package com.system.controller;

import com.system.mapper.RoomBindingMapper;
import com.system.pojo.Room;
import com.system.pojo.User_Account;
import com.system.service.RoomBindingService;
import com.system.service.RoomService;
import com.system.service.User_AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class Room_bindingController {
    @Autowired
    private RoomBindingService roomBindingService;
    @Autowired
    private User_AccountService user_accountService;

    /**
     * 用户绑定展示操作
     * @return
     */
    @RequestMapping("/room_bingding.do")
    public ModelAndView showPropritor(){
        List<User_Account> user_accounts = roomBindingService.selectAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",user_accounts);
        modelAndView.setViewName("Room_binding.jsp");
        return modelAndView;
    }

    /**
     * 绑定细节
     * @param id
     * @return
     */
    @RequestMapping("/RoomDetails.do")
    public ModelAndView RoomDetails(Integer id){
        List<Room> roomList = roomBindingService.selectRoomId(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",roomList);
        modelAndView.setViewName("RoomDetails.jsp");
        return modelAndView;
    }

    /**
     * 解除绑定
     * @param id 房间id
     * @return
     */
    @RequestMapping("/relieveRoom.do")
    public ModelAndView relieveRoom(Integer id,Integer user_id){
        Integer integer = roomBindingService.setState(id);
        return RoomDetails(user_id);
    }

    /**
     * 展示未绑定房间信息
     * @param chick 用户id
     * @return
     */
    @RequestMapping("/showRooms.do")
    public ModelAndView showRooms(Integer chick){
        System.out.println(chick);
        User_Account user_account = user_accountService.selectById(chick);
        System.out.println("绑定用户："+user_account);
        List<Room> roomList = roomBindingService.selectRoom();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user_account",user_account);
        modelAndView.addObject("list",roomList);
        modelAndView.setViewName("ChooseRoom.jsp");
        return modelAndView;
    }

    /**
     * 绑定房间信息
     * @param user_id 业主id
     * @param chick 房间id
     * @return
     */
    @RequestMapping("/bind_information.do")
    public ModelAndView bind_information(Integer user_id,Integer[] chick){
        System.out.println(user_id);
        System.out.println(chick);
        Room room = new Room();
        room.setUser_id(user_id);

        for(Integer id:chick){
            room.setRoom_id(id);
            roomBindingService.setRoomState(room);
        }
        return showRooms(user_id) ;
    }

    @RequestMapping("/selectByUserName.do")
    public ModelAndView selectByUserName(String user_name){
        List<User_Account> user_accounts = user_accountService.selectByName(user_name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list",user_accounts);
        modelAndView.setViewName("Room_binding.jsp");
        return modelAndView;
    }
}
