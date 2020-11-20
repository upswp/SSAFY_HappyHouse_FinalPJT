package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;

public interface HouseMapService {
	/**
	 * 시도 리스트 반환
	 * @return
	 * @throws Exception
	 */
	List<SidoGugunCodeDto> getSido();
	/**
	 * 구군 리스트 반환
	 * @param sido
	 * @return
	 * @throws Exception
	 */
	List<SidoGugunCodeDto> getGugunInSido(String sido);
}