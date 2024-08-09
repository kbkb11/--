package com.example.BusQuerySystem.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("CityRoutes")
public class CityRoute {
    @TableId
    private int id;
    private String province;
    private String city;
    private String routeName;
    private String link;
}
