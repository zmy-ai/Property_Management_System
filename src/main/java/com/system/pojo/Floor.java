package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Floor {
    private int id;
    private String  floor_name;
    private int unit;
    private int level;
    private int room_amount;

    public Floor(String floor_name, int unit, int level, int room_amount) {
        this.floor_name = floor_name;
        this.unit = unit;
        this.level = level;
        this.room_amount = room_amount;
    }
}
