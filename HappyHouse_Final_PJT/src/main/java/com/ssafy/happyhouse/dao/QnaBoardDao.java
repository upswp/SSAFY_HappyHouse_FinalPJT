package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.QnaBoardDto;
@Mapper
public interface QnaBoardDao {
	public List<QnaBoardDto> selectBoard();
	public QnaBoardDto selectBoardByNo(int no);
	public int insertBoard(QnaBoardDto board);
	public int updateBoard(QnaBoardDto board);
	public int deleteBoard(int no);
}