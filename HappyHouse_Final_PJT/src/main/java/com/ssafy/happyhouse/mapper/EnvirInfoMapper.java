package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.EnvirInfoDto;


@Mapper
public interface EnvirInfoMapper {
	public List<EnvirInfoDto> selectEnvInfoByDong(String sigugun, String dong);
}
