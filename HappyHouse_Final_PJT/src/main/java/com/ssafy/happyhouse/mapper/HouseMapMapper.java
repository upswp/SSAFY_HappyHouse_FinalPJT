package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {
	
	public List<SidoGugunCodeDto> selectSido();
	public List<SidoGugunCodeDto> selectGugun(String sido);
	public List<SidoGugunCodeDto> selectDong(String gugun);
	public String selectSidoName(String sidocode);
	public String selectGugunName(String guguncode);
	public String selectDongName(String dongcode);
	public String selectSiCode(String siname);
	public String selectGugunCode(String gugunname,String sidocode);
	
}
