package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
    private int  room_id;
    private String floor_name;
    private String floor_unit;
    private String room_number;
    private int room_area;
    private int user_id;
    private int state;//绑定状态

    //一间房对应一个业主
    private User_Account userAccount;

    public Room(String floor_name, String floor_unit, String room_number, int room_area) {
        this.floor_name = floor_name;
        this.floor_unit = floor_unit;
        this.room_number = room_number;
        this.room_area = room_area;
    }
}
