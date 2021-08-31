package com.system.mapper;


import com.system.pojo.Admin_Account;
import com.system.pojo.User_Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DateMapper {
    @Select("SELECT * FROM `admin_account`")
    public List<Admin_Account> select();

    @Select("SELECT * FROM `admin_account` where username=#{username}")
    public  Admin_Account selectByName_Admin(String username);

    @Insert("insert into `admin_account`(username,`password`,phone,email)values(#{username},#{password},#{phone},#{email})")
    public Integer insertinto_Admin(Admin_Account admin_account);

    @Select("select * from user_account where idcard=#{userIdcard} ")
    public User_Account selectUserIdcard(String userIdcard);
}
