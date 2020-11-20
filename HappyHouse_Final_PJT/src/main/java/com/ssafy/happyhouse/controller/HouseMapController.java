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

import com.ssafy.happyhouse.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.service.HouseMapService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/map")
public class HouseMapController {

	private static final Logger logger = LoggerFactory.getLogger(HouseMapController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private HouseMapService housemapService;

	@ApiOperation(value = "모든 시도를 반환한다.", response = List.class)
	@GetMapping(value = "/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> getSido() throws Exception{
		logger.debug("getSido - 호출");
		return new ResponseEntity<List<SidoGugunCodeDto>>(housemapService.getSido(),HttpStatus.OK);
	}
	
	@ApiOperation(value = "선택한 시코드로 구군을 반환한다.", response = List.class)
	@RequestMapping(value = "/sido/{sidoCode}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<SidoGugunCodeDto> getGugunInSido(@PathVariable("sidoCode") String sido) throws Exception {
		return housemapService.getGugunInSido(sido);
	}
	
}