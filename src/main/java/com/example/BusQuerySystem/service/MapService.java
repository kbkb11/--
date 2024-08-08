package com.example.BusQuerySystem.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface MapService {
    // 获取指定地点的坐标
    Map<String, String> getCoordinates() throws Exception;

    // 获取默认的地图中心点坐标
    Map<String, Double> getDefaultCoordinates();
}
