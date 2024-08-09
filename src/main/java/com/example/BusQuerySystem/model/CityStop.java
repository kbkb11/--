package com.example.BusQuerySystem.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cityStops")
public class CityStop {
    @TableId
    private int id;
    private String province;
    private String city;
    private String stopName;
}
