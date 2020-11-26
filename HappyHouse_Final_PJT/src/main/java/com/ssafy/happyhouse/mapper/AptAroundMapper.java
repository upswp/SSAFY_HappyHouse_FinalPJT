package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.CoronaClinicDto;
import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.dto.HospitalDto;
import com.ssafy.happyhouse.dto.StoreInfoDto;


@Mapper
public interface AptAroundMapper {
	// 시도구군, 동으로 주변환경정보 가져오기
	public List<EnvirInfoDto> selectEnvInfoByDong(String sidogugun, String dong);
	// 시도, 구군, 동으로 주변상가정보 가져오기
	public List<StoreInfoDto> selectStoreInfoByDong(String sido, String gugun, String dong);
	// 시도, 구군으로 안심병원 가져오기
	public List<HospitalDto> selectHospitalByGugun(String sido, String gugun);
	// 시도, 구군으로 코로나 선별진료소 가져오기
	public List<CoronaClinicDto> selectCoronaClinicByGugun(String sido, String gugun);
}
