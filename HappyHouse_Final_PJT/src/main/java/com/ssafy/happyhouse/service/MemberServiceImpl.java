package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<MemberDto> retrieveMember() throws Exception {
		return sqlSession.getMapper(MemberMapper.class).retrieveMember();
	}

	@Override
	public MemberDto detailMember(int no) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).detailMember(no);
	}

	@Override
	public boolean joinMember(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).joinMember(memberDto) == 1;
	}

	@Override
	@Transactional
	public boolean updateMember(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).updateMember(memberDto) == 1;
	}

	@Override
	@Transactional
	public boolean deleteMember(int no) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).deleteMember(no) == 1;
	}

	@Override
	public List<MemberDto> searchMember(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).searchMember(userid);
	}

}
