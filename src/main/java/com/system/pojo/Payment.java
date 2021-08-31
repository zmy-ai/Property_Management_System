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
public class Payment {
    private int id;
    private String pay_name;
    private int money;
    private Date outTime;
    private int user_id;
    private String explain;
    private String pay_state;
    private Date createTime;

    private User_Account user_account;

    public Payment(int id, String pay_name, int money, String explain, String pay_state) {
        this.id = id;
        this.pay_name = pay_name;
        this.money = money;
        this.explain = explain;
        this.pay_state = pay_state;
    }

    public Payment(String pay_name, int money, String explain, String pay_state) {
        this.pay_name = pay_name;
        this.money = money;
        this.explain = explain;
        this.pay_state = pay_state;
    }
}
