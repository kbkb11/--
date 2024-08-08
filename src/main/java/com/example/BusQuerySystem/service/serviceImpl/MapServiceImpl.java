package com.example.BusQuerySystem.service.serviceImpl;

import com.example.BusQuerySystem.config.BaiduConfig;
import com.example.BusQuerySystem.service.MapService;
import com.example.BusQuerySystem.utils.gson.LocationResponse;
import com.example.BusQuerySystem.utils.ip.HttpRequestUtils;
import com.example.BusQuerySystem.utils.ip.SNUtils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MapServiceImpl implements MapService {

    private final BaiduConfig baiduConfig;
    @Autowired
    public MapServiceImpl(BaiduConfig baiduConfig) {
        this.baiduConfig = baiduConfig;
    }


    // 示例方法：根据给定的地点获取坐标
    @Override
    public Map<String, String> getCoordinates() throws Exception {
        String AK = baiduConfig.getAk();
        String SK = baiduConfig.getSk();

        // 设置API请求的参数
        Map<String, String> params = new LinkedHashMap<>();
//        params.put("ip", "182.100.57.235");
        params.put("coor", "bd09ll");
        params.put("ak", AK);

        // 计算SN签名
        String sn = SNUtils.calculateSn(params, AK, SK,"/location/ip?");
        params.put("sn", sn);

        // 发送HTTP GET请求并获取响应
        String response = HttpRequestUtils.requestGetSN("http://api.map.baidu.com/location/ip?", params);
        System.out.println(response);

        // 使用 Gson 解析 JSON 数据
        Gson gson = new Gson();
        LocationResponse locationResponse = gson.fromJson(response, LocationResponse.class);

        Map<String, String> coordinates = new HashMap<>();
        coordinates.put("latitude", locationResponse.getContent().getPoint().getY());
        coordinates.put("longitude", locationResponse.getContent().getPoint().getX());

        return coordinates;
    }

    // 获取默认的地图中心点坐标
    @Override
    public Map<String, Double> getDefaultCoordinates() {
        Map<String, Double> coordinates = new HashMap<>();
        coordinates.put("latitude", 39.915); // 默认北京市
        coordinates.put("longitude", 116.404);
        return coordinates;
    }
}
