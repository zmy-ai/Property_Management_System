package com.system.mapper;

import com.system.pojo.User_Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface User_AccountMapper {
    @Select("select * from `user_account` where idcard=#{idcard}")
    public User_Account selectByIdCard(String idcard);

    @Select("select * from `user_account` where id=#{id}")
    public User_Account selectById(Integer id);

    @Select("select * from `user_account`")
    public List<User_Account> selectAll();

    @Insert("insert into `user_account`(username,sex,idcard,phone,email,`password`,createTime)values(#{username},#{sex},#{idcard},#{phone},#{email},#{password},#{createTime});")
    public  Integer insert(User_Account user_account);

    @Delete("delete from `user_account` where id=#{id}")
    public  Integer delete(Integer id);

    @Update("update user_account set username=#{username},sex=#{sex},idcard=#{idcard},phone=#{phone},email=#{email},`password`=#{password},createTime=#{createTime} where id=#{id}")
    public Integer update(User_Account user_account);

    @Select("select * from user_account where username=#{username}")
    public List<User_Account> selectByName(String username);
}
