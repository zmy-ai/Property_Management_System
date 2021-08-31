package com.system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Complain {
    private int id;
    private String title;
    private String detail;
    private String name;
    private int user_id;
    private String property_state;
}
