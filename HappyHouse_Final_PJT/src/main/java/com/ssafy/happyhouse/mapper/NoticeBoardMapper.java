package com.ssafy.happyhouse.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.NoticeBoardDto;

@Mapper
public interface NoticeBoardMapper {
	public List<NoticeBoardDto> selectBoard();
	public NoticeBoardDto selectBoardByNo(int no);
	public int insertBoard(NoticeBoardDto board);
	public int updateBoard(NoticeBoardDto board);
	public int deleteBoard(int no);
}