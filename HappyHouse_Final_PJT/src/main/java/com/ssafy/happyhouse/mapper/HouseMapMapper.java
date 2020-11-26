package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

@Mapper
public interface HouseMapMapper {
	
	// 시도 리스트 반환
	public List<SidoGugunCodeDto> selectSido();
	// 구군 리스트 반환
	public List<SidoGugunCodeDto> selectGugun(String sido);
	// 동 리스트 반환
	public List<SidoGugunCodeDto> selectDong(String gugun);
	// 시도 코드로 시도 이름 반환
	public String selectSidoName(String sidocode);
	// 구군 코드로 구군 이름 반환
	public String selectGugunName(String guguncode);
	// 동 코드로 동 이름 반환
	public String selectDongName(String dongcode);
	// 시도 이름으로 시도 코드 반환
	public String selectSiCode(String siname);
	// 구군 이름으로 구군 코드 반환
	public String selectGugunCode(String gugunname,String sidocode);
	
}
