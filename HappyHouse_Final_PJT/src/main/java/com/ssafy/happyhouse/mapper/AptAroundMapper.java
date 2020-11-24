package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.CoronaClinicDto;
import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.dto.HospitalDto;
import com.ssafy.happyhouse.dto.StoreInfoDto;


@Mapper
public interface AptAroundMapper {
	public List<EnvirInfoDto> selectEnvInfoByDong(String sidogugun, String dong);
	public List<StoreInfoDto> selectStoreInfoByDong(String sido, String gugun, String dong);
	public List<HospitalDto> selectHospitalByGugun(String sido, String gugun);
	public List<CoronaClinicDto> selectCoronaClinicByGugun(String sido, String gugun);
}
