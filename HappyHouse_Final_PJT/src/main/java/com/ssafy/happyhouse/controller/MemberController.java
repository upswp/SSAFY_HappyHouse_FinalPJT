package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.service.JwtService;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/user")
public class MemberController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	/**
	 * ====================================================================================================
	 * =========================================로그인 관련controller=========================================
	 * ====================================================================================================
	 */

	/**
	 * 로그인 token 검사
	 * 
	 * @param memberDto
	 * @param response
	 * @param session
	 * @return
	 */
	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto, HttpServletResponse response,
			HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("USERID::::" + memberDto.getUserid());
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);

			if (loginUser != null) {
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
	 * 
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

	/**
	 * ====================================================================================================
	 * =========================================회원 정보 관리controller========================================
	 * ====================================================================================================
	 */

	/**
	 * 모든 회원 정보 리스트를 반환한다.
	 * 
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "모든 회원의 정보를 반환한다.", response = List.class)
	@GetMapping("/selectMember")
	public ResponseEntity<List<MemberDto>> retrieveMember() throws Exception {
		logger.debug("retrieveMember - 호출");
		return new ResponseEntity<List<MemberDto>>(memberService.retrieveMember(), HttpStatus.OK);
	}

	/**
	 * 회원 아이디에 대한 상세보기 기능 제공
	 * 
	 * @param no 선택한 글 번호
	 * @return
	 * @throws Exception
	 */
	@ApiOperation(value = "회원번호에 해당하는 회원의 정보를 반환한다.", response = MemberDto.class)
	@GetMapping("/detailMember/{no}")
	public ResponseEntity<MemberDto> detailMember(@PathVariable int no) throws Exception {
		logger.debug("detailMember - 호출");
		return new ResponseEntity<MemberDto>(memberService.detailMember(no), HttpStatus.OK);
	}

	/**
	 * 회원 가입 create
	 * 
	 * @param memberDto 입력한 게시글 정보 데이터
	 * @return
	 */
	@ApiOperation(value = "새로운 회원 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/joinMember")
	public ResponseEntity<String> writeMember(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("joinMember - 호출" + memberDto);
		if (memberService.joinMember(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	/**
	 * 회원 아이디 값에 대한 글 정보 수정
	 * 
	 * @param memberDto 선택한 게시글에 대한 글 정보
	 * @return
	 */
	@ApiOperation(value = "회원번호에 해당하는 회원의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("/updateMember/{no}")
	public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) throws Exception {
		logger.debug("updateMember - 호출");
		logger.debug("" + memberDto);

		if (memberService.updateMember(memberDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	/**
	 * 회원 아이디 대한 정보 삭제
	 * 
	 * @param no 해당 글 번호
	 * @return
	 */
	@ApiOperation(value = "회원번호에 해당하는 회원의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("/deleteMember/{no}")
	public ResponseEntity<String> deleteMember(@PathVariable int no) throws Exception {
		logger.debug("deleteMember - 호출");
		if (memberService.deleteMember(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
