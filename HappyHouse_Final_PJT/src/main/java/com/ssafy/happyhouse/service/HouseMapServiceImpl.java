package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.mapper.HouseMapMapper;

@Service
public class HouseMapServiceImpl implements HouseMapService {

	@Autowired
	private HouseMapMapper sidoguguncodedto;
	
	@Override
	public List<SidoGugunCodeDto> getSido(){
		return sidoguguncodedto.selectSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido){
		return sidoguguncodedto.selectGugun(sido);
	}

	@Override
	public List<SidoGugunCodeDto> getDongInGugun(String gugun) {
		return sidoguguncodedto.selectDong(gugun);
	}


}
