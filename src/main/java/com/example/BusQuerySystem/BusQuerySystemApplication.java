package com.example.BusQuerySystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.BusQuerySystem.mapper")
public class BusQuerySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusQuerySystemApplication.class, args);
	}

}
