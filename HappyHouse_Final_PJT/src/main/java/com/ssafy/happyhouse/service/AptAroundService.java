package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.CoronaClinicDto;
import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.dto.HospitalDto;
import com.ssafy.happyhouse.dto.StoreInfoDto;

public interface AptAroundService {
	List<EnvirInfoDto> getEnvirInfo(String sigugun, String dong);
	List<StoreInfoDto> getAllStoreInfo(String sido, String gugun, String dong);
	List<HospitalDto> getAllHospInGugun(String sido, String gugun);
	List<CoronaClinicDto> getAllCoronaClinicInGugun(String sido, String gugun);
}
