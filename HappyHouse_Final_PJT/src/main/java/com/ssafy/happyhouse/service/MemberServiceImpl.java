package com.ssafy.happyhouse.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.MemberDto;
import com.ssafy.happyhouse.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public String getServerInfo() {
		return "사용자에게 전달하고 싶은 중요정보";
	}

	@Override
	public List<MemberDto> retrieveMember() {
		return memberMapper.retrieveMember();
	}

	@Override
	public MemberDto detailMember(int no) {
		return memberMapper.detailMember(no);
	}

	@Override
	public boolean joinMember(MemberDto memberDto) {
		return memberMapper.joinMember(memberDto) == 1;
	}

	@Override
	public boolean updateMember(MemberDto memberDto) {
		return memberMapper.updateMember(memberDto) == 1;
	}

	@Override
	public boolean deleteMember(int no) {
		return memberMapper.deleteMember(no) == 1;
	}

}
