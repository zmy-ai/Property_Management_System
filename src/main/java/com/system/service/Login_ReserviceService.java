package com.system.service;

import com.system.pojo.Admin_Account;
import com.system.pojo.User_Account;

public interface Login_ReserviceService {
    /**
     * 管理员用户查询
     * @param username 用户账号
     * @return 返回一个账号信息，表示账号存在，若返回null表示账号不存在
     */
    public Admin_Account selectByName_Admin(String username);

    /**
     * 管理员账户注册
     * @param admin_account 管理员账户信息
     * @return 返回0或者一个非0数，若返回0，账户注册失败，否则注册成功！
     */
    public  Integer  insertUser(Admin_Account admin_account);

    public User_Account selectUserIdcard(String userIdcard);
}
