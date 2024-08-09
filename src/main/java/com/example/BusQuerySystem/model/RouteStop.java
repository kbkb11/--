package com.example.BusQuerySystem.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("RouteStops")
public class RouteStop {
    @TableId
    private int id;
    private int routeId;
    private String stopName;
    private int stopOrder;
}
