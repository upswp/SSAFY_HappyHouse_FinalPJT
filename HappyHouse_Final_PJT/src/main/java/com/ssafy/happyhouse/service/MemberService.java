package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.MemberDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;

	public String getServerInfo();

	public List<MemberDto> retrieveMember() throws Exception;

	public MemberDto detailMember(int no) throws Exception;

	public boolean joinMember(MemberDto memberDto) throws Exception;

	public boolean updateMember(MemberDto memberDto) throws Exception;

	public boolean deleteMember(int no) throws Exception;

}
