package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.CoronaClinicDto;
import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.dto.HospitalDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.dto.StoreInfoDto;
import com.ssafy.happyhouse.service.AptAroundService;
import com.ssafy.happyhouse.service.HouseMapService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/aptaround")
public class AptAroundController {
	// 아파트 주변환경정보
	
	private static final Logger logger = LoggerFactory.getLogger(AptAroundController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private AptAroundService aptaroundService;
	
	@ApiOperation(value = "선택한 시구군,동으로 주변환경정보를 반환한다.", response = List.class)
	@GetMapping(value = "/env/{sidogugun}/{dong}")
	public List<EnvirInfoDto> getGugunInSido(@PathVariable("sidogugun") String sidogugun,@PathVariable("dong") String dong) throws Exception {
		return aptaroundService.getEnvirInfo(sidogugun, dong);
	}
	
	@ApiOperation(value = "선택한 시,구군,동으로 상가정보를 반환한다.", response = List.class)
	@GetMapping(value = "/store/{sido}/{gugun}/{dong}")
	public List<StoreInfoDto> getAllStoreInDong(@PathVariable("sido") String sido,
			@PathVariable("gugun") String gugun,
			@PathVariable("dong") String dong) throws Exception {
		logger.debug("get상가정보 - 호출");
		return aptaroundService.getAllStoreInfo(sido, gugun, dong);
	}
	
	@ApiOperation(value = "선택한 시구군,동으로 병원정보를 반환한다.", response = List.class)
	@GetMapping(value = "/hospital/{sido}/{gugun}")
	public List<HospitalDto> getAllHospInGugun(@PathVariable("sido") String sido,@PathVariable("gugun") String gugun) throws Exception {
		logger.debug("gethospital - 호출");
		return aptaroundService.getAllHospInGugun(sido, gugun);
	}
	
	@ApiOperation(value = "선택한 시구군,동으로 코로나선별진료소정보를 반환한다.", response = List.class)
	@GetMapping(value = "/coronaclinic/{sido}/{gungu}")
	public List<CoronaClinicDto> getAllCoronaClinicInGugun(@PathVariable("sido") String sido,@PathVariable("gungu") String gungu) throws Exception {

		logger.debug("getcorona - 호출");
		return aptaroundService.getAllCoronaClinicInGugun(sido, gungu);
	}
}