package com.system.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MyUser {
    private int id;
    private String  username;
    private Date birthday;
    private String sex;
    private String address;

    public MyUser(int id, String username, String sex, String address) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
    }

    public MyUser(String username, String sex, String address) {
        this.username = username;
        this.sex = sex;
        this.address = address;
    }
}
