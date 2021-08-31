package com.system.service;

import com.system.pojo.User_Account;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface User_AccountService {

    /**
     * 根据用户证件号查找用户
     * @param idcard 用户的证件号
     * @return 返回一个用户的详细信息
     */
    public User_Account selectByIdCard(String idcard);

    /**
     * 查找所以用户信息
     * @return 所有用户信息的list集合
     */
    public List<User_Account> selectAll();

    /**
     * 根据用户id查找数据
     * @param id 用户id
     * @return 返回一个用户信息
     */
    public User_Account selectById(Integer id);

    /**
     * 添加用户信息
     * @param user_account 添加的用户信息
     * @return 返回添加至数据库数据表被修改的行数
     */
    public Integer insertUser(User_Account user_account);

    /**
     * 根据用户id删除用户信息
     * @param id 需要删除的用户id
     * @return 删除数据库表数据的行数
     */
    public Integer deleteUser(Integer id);

    /**
     * 更新用户信息
     * @param user_account 更新之后的数据库数据
     * @return 返回数据库修改数据的行数
     */
    public  Integer uptadeUser(User_Account user_account);

    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return 返回查找到的所有用户名信息
     */
    public  List<User_Account> selectByName(String username);

    /**
     * 导出用户表的Excle表
     * @return 用户表的Excle表
     * @throws Exception 如果发生所系信息，返回答应错误日志
     */
    public Workbook queryExportUser() throws Exception;
}
