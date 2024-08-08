package com.example.BusQuerySystem.service.serviceImpl;

import com.example.BusQuerySystem.config.BaiduConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaiduConfigService {
    private final BaiduConfig baiduConfig;

    @Autowired
    public BaiduConfigService(BaiduConfig baiduConfig) {
        this.baiduConfig = baiduConfig;
    }

    public void printConfig() {
        System.out.println("ak: " + baiduConfig.getAk());
        System.out.println("sk: " + baiduConfig.getSk());
        System.out.println("url: " + baiduConfig.getUrl());
    }
}
