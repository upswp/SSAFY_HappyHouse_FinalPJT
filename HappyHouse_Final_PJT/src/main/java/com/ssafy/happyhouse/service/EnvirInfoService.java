package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.EnvirInfoDto;

public interface EnvirInfoService {
	List<EnvirInfoDto> getEnvirInfo(String sigugun, String dong);
}
