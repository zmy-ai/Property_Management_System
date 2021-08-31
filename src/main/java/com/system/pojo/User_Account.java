package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User_Account {
    private int id;
    private String username;
    private String sex;
    private String idcard;
    private String phone;
    private String email;
    private String password;
    private Date createTime;

    private List<Room> roomList;

    public User_Account(String username, String sex, String idcard, String phone, String email, String password) {
        this.username = username;
        this.sex = sex;
        this.idcard = idcard;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
