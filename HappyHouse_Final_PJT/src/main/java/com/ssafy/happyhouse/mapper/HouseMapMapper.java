package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

public interface HouseMapMapper {
	
	public List<SidoGugunCodeDto> selectSido();
	public List<SidoGugunCodeDto> selectGugun(String sido);
	public List<SidoGugunCodeDto> selectDong(String gugun);
	
	//수정했다고 바뀌라고!!!!!!!!
}
