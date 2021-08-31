package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin_Account {
    private  int  id;//管理员编号
    private String username;//用户名
    private String password;//用户密码
    private String phone;//联系电话
    private  String  email;//邮箱

    public Admin_Account(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
