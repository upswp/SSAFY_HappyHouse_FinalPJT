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

import com.ssafy.happyhouse.dto.EnvirInfoDto;
import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.service.EnvirInfoService;
import com.ssafy.happyhouse.service.HouseMapService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/aptaround")
public class AptAroundController {

	private static final Logger logger = LoggerFactory.getLogger(AptAroundController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private EnvirInfoService envirinfoService;
	
	@ApiOperation(value = "선택한 시구군,동으로 주변환경정보를 반환한다.", response = List.class)
	@GetMapping(value = "/env/{sidogugun}/{dong}")
	public List<EnvirInfoDto> getGugunInSido(@PathVariable("sidogugun") String sidogugun,@PathVariable("dong") String dong) throws Exception {
		return envirinfoService.getEnvirInfo(sidogugun, dong);
	}
}