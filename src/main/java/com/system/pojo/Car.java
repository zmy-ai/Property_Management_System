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
public class Car {
    private int id;
    private String car_id;
    private String type;
    private int car_area;
    private Date createtime;
    private Date outTime;
    private int user_id;//业主id

    //一个车位对应一个业主
    private User_Account user_account;

    public Car(String car_id, String type) {
        this.car_id = car_id;
        this.type = type;
    }
}
