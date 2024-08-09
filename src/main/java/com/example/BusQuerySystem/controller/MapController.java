package com.example.BusQuerySystem.controller;

import com.example.BusQuerySystem.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/processLocations")
    @ResponseBody
    public Map<String, String> processLocations(@RequestParam("startLocation") String startLocation,
                                                @RequestParam("endLocation") String endLocation) throws Exception {
        // 根据位置名称获取经纬度
        Map<String, String> startCoordinates = mapService.getCoordinatesForLocation(startLocation);
        Map<String, String> endCoordinates = mapService.getCoordinatesForLocation(endLocation);

        return Map.of(
                "startLat", startCoordinates.get("latitude"),
                "startLng", startCoordinates.get("longitude"),
                "endLat", endCoordinates.get("latitude"),
                "endLng", endCoordinates.get("longitude")
        );
    }
}
