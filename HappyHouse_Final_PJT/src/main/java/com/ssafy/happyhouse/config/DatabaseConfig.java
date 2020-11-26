package com.ssafy.happyhouse.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
/**
 * 데이터 mapper와 연결
 * @author Park Sangwoo
 *
 */
@Configuration
@MapperScan(
		basePackages = "com.ssafy.happyhouse.mapper"
)
public class DatabaseConfig {}