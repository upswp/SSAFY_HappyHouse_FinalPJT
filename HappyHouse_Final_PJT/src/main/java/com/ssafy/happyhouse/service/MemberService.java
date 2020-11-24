package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public String getServerInfo();
	public List<MemberDto> retrieveMember();
	public MemberDto detailMember(int no);
	public boolean joinMember(MemberDto memberDto);
	public boolean updateMember(MemberDto memberDto);
	public boolean deleteMember(int no);
	
}
