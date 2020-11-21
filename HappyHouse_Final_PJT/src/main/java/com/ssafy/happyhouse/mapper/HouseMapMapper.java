package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {
	
	public List<SidoGugunCodeDto> selectSido();
	public List<SidoGugunCodeDto> selectGugun(String sido);
	public List<SidoGugunCodeDto> selectDong(String gugun);
	
}
