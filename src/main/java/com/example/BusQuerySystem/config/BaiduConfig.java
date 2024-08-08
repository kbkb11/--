package com.example.BusQuerySystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "baidu")
@Getter
@Setter
public class BaiduConfig {
    private String ak;
    private String sk;
    private String url;
}