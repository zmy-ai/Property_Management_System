package com.system.service;

import com.system.pojo.Room;
import com.system.pojo.User_Account;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface RoomBindingService {
    public List<User_Account> selectAll();
    public List<Room>  selectRoomId(Integer userid);

    /**
     * 解除绑定，修改绑定用户和绑定状态
     * @param id
     * @return
     */
    public Integer setState(Integer id);

    /**
     * 查找未被绑定的房间
     * @return
     */
    public List<Room> selectRoom();

    /**
     * 设置房间绑定虚拟
     * @param room 设置的房间状态信息
     * @return 数据库中数据数据表修改的行数
     */
    public Integer setRoomState(Room room);

}
