package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.MemberService;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class MemberController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;
	
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	/**
	 * 로그인 token 검사
	 * @param memberDto
	 * @param response
	 * @param session
	 * @return
	 */
	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto, HttpServletResponse response, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("USERID::::"+memberDto.getUserid());
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);
			
			if(loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);
				
//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("status", false);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	/**
	 * 사용자 회원정보 반환
	 * @param req
	 * @return
	 */
	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(req.getHeader("auth-token"));
		System.out.println(">>>>>> " + jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
//			String info = memberService.getServerInfo();
			
			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));
//
//			resultMap.put("status", true);
//			resultMap.put("info", info);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

}
