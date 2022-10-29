package com.braisedpanda.shirotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching

public class ShirotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShirotestApplication.class, args);
	}

}
