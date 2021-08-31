package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Maintain {
    private int id;
    private String title;
    private String detail;
    private String name;
    private int user_id;
    private String address;//报修地址
    private String phone;//联系电话
    private String property_state;
    private String user_state;

    private User_Account user_account;

    public Maintain(String title, String detail, String name, String address, String phone, String property_state, String user_state, User_Account user_account) {
        this.title = title;
        this.detail = detail;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.property_state = property_state;
        this.user_state = user_state;
        this.user_account = user_account;
    }
}
