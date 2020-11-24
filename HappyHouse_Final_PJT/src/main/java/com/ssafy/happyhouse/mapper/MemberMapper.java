package com.ssafy.happyhouse.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public List<MemberDto> retrieveMember();
	public MemberDto detailMember(int no);
	public int joinMember(MemberDto memberDto);
	public int updateMember(MemberDto memberDto);
	public int deleteMember(int no);
}
