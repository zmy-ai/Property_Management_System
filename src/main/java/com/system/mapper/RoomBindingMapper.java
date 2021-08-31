package com.system.mapper;

import com.system.pojo.Room;
import com.system.pojo.User_Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Repository
public interface RoomBindingMapper {

    @Select("select * from user_account")
/*    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(id = true,column = "idcard",property = "idcard"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "createTime",property = "createTime"),
            @Result(column = "id",property = "roomList",many = @Many(select = "com.system.mapper.RoomBinding.selectRoom",fetchType = FetchType.EAGER))

    })*/
    public List<User_Account> selectAll();

    @Select("select * from room where user_id=#{user_id}")
    public List<Room>  selectRoomId(Integer user_id);

    @Update("update room set user_id=0,state=0 where room_id=#{id}")
    public Integer setState(Integer id);

    @Select("select * from room where `state`=0")
    public List<Room> selectRoom();

    @Update("update room set user_id=#{user_id},state=1 where room_id=#{room_id}")
    public Integer setRoomState(Room room);

}
