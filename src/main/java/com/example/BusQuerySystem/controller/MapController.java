package com.example.BusQuerySystem.controller;

import com.example.BusQuerySystem.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/map")
    public String getMap(Model model) throws Exception {
        // 获取默认的地图中心点坐标
        Map<String, String> coordinates = mapService.getCoordinates();
        model.addAttribute("latitude", coordinates.get("latitude"));
        model.addAttribute("longitude", coordinates.get("longitude"));

        return "map/baiDuMap"; // 返回Thymeleaf模板名称
    }
}
