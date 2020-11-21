package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.mapper.EnvirInfoMapper;

@Service
public class EnvirInfoServiceImpl implements EnvirInfoService{
	@Autowired
	private EnvirInfoMapper env;
	@Override
	public List<EnvirInfoDto> getEnvirInfo(String sigugun, String dong) {
		// TODO Auto-generated method stub
		return env.selectEnvInfoByDong(sigugun, dong);
	}

}

